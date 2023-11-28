package org.tacc.green1.model.catalog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.Optional;


public class FilterDropdown extends Modal<FilterDropdown> implements XPath.FilterDropdown {
    private static final Logger LOG = LogManager.getLogger(FilterDropdown.class);
    private boolean expanded = false;

    @FindBy(xpath = LABEL_NAME)
    private WebElement nameLabel;

    @FindAll({
            @FindBy(xpath = OPTIONS_LIST)
    })
    private List<WebElement> listOptions;

    @FindAll({
            @FindBy(xpath = OPTIONS_SQUARE)
    })
    private List<WebElement> squareOptions;


    public FilterDropdown(SearchContext context) {
        super(context);
    }


    public String getName() {
        return nameLabel.getText();
    }

    /**
     * Expand/collapse filter dropdown
     */
    private void toggleCollapsible() {
        nameLabel.click();
    }

    /**
     * Applies filter parameter
     *
     * @param argument color, size, or any other parameter
     */
    public void apply(String argument) {
        //Expand filter dropdown first
        if (!expanded) {
            expanded = true;
            toggleCollapsible();
            LOG.debug("Filter dropdown expanded");
        }

        LOG.debug("List options available for filtering: " + listOptions.size());
        LOG.debug("Square options available for filtering: " + squareOptions.size());

        Optional<WebElement> requestedOption;
        if (!listOptions.isEmpty())
            //Round #1: Try looking for normal list items
            requestedOption = listOptions.stream()
                    .filter(webElement -> webElement
                            .getText()
                            .toLowerCase()
                            .contains(argument.toLowerCase()))
                    .findFirst();
        else
            //Round #2: Try looking for square options
            requestedOption = squareOptions.stream()
                    .filter(webElement -> webElement
                            .getAttribute("option-label")
                            .toLowerCase()
                            .contains(argument.toLowerCase()))
                    .findFirst();


        //Oops, nothing found
        if (requestedOption.isEmpty()) {
            String message = "No corresponding argument was found by name: " + argument;
            LOG.error(message);
            throw new IllegalArgumentException(message);
        }

        LOG.debug("Found corresponding filter for argument: " + argument);

        //Finally apply filter
        requestedOption.get().click();
    }
}