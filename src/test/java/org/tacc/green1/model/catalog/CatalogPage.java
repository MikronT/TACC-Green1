package org.tacc.green1.model.catalog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.tacc.green1.model.Modal;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.stream.Collectors;


public class CatalogPage extends Modal<CatalogPage> implements XPath.CatalogPage {
    private static final Logger LOG = LogManager.getLogger(CatalogPage.class);

    @FindBy(xpath = DROPDOWN_LIMITER)
    private WebElement limiterDropdown;

    @FindAll({
            @FindBy(xpath = FILTER_DROPDOWNS)
    })
    private List<WebElement> filterDropdowns;

    private List<FilterDropdown> filters = null;

    @FindAll({
            @FindBy(xpath = PRODUCT_CARDS)
    })
    private List<WebElement> productCards;


    /**
     * Ensures the catalog frame is loaded completely and ready for interaction through any other method
     */
    protected void waitForAjax() {
        modalWait().until(ExpectedConditions.visibilityOf(limiterDropdown));
    }

    public CatalogPage showMaxProductsPerPage() {
        waitForAjax();

        var limiterSelect = new Select(limiterDropdown);

        int optionsCount = limiterSelect.getOptions().size();
        int lastOptionIndex = optionsCount - 1;
        limiterSelect.selectByIndex(lastOptionIndex);

        return this;
    }


    private List<FilterDropdown> getAllFilters() {
        waitForAjax();

        if (filters == null)
            filters = filterDropdowns.stream()
                    .map(dropdown -> PageFactory.initElements(dropdown, FilterDropdown.class))
                    .collect(Collectors.toList());

        return filters;
    }

    private FilterDropdown getFilter(String name) {
        List<FilterDropdown> foundFilters = getAllFilters().stream()
                .filter(filterDropdown -> name.equalsIgnoreCase(filterDropdown.getName()))
                .toList();

        //Required filter was found
        if (foundFilters.size() == 1)
            return foundFilters.get(0);

        //Oops, too much
        if (foundFilters.size() > 1) {
            String message = "Multiple filters were found corresponding to name: " + name;
            LOG.error(message);
            throw new IllegalArgumentException(message);
        }

        //Oops, not enough
        String message = "No filter was found corresponding to name: " + name;
        LOG.error(message);
        throw new NotFoundException(message);
    }

    public CatalogPage applyFilter(String name, String argument) {
        LOG.info("Applying filter " + name + " with argument " + argument);
        getFilter(name).apply(argument);
        return this;
    }


    public List<ProductCard> getVisibleProductCards() {
        return productCards.stream()
                .map(card -> PageFactory.initElements(card, ProductCard.class))
                .collect(Collectors.toList());
    }

    public Cart initCart() {
        return PageFactory.initElements(modalDriver, Cart.class);
    }
}