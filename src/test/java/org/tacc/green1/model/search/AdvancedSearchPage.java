package org.tacc.green1.model.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;
import org.tacc.green1.model.catalog.CatalogPage;


public class AdvancedSearchPage extends Modal<AdvancedSearchPage> {
    @FindBy(id = "name")
    private WebElement productNameInput;
    @FindBy(id = "sku")
    private WebElement productSKUInput;
    @FindBy(id = "description")
    private WebElement productDescriptionInput;
    @FindBy(id = "short_description")
    private WebElement productShortDescriptionInput;
    @FindBy(id = "price")
    private WebElement productPriceFromInput;
    @FindBy(id = "price_to")
    private WebElement productPriceToInput;

    @FindBy(css = "#form-validate > div > div > button")
    private WebElement submitButton;


    public AdvancedSearchPage fillProductName(String name) {
        productNameInput.sendKeys(name);
        return this;
    }

    public AdvancedSearchPage fillProductSKU(String sku) {
        productSKUInput.sendKeys(sku);
        return this;
    }

    public AdvancedSearchPage fillProductDescription(String description) {
        productDescriptionInput.sendKeys(description);
        return this;
    }

    public AdvancedSearchPage fillProductShortDescription(String short_description) {
        productShortDescriptionInput.sendKeys(short_description);
        return this;
    }

    public AdvancedSearchPage fillProductPriceFrom(String price) {
        productPriceFromInput.sendKeys(price);
        return this;
    }

    public AdvancedSearchPage fillProductPriceTo(String price_to) {
        productPriceToInput.sendKeys(price_to);
        return this;
    }

    public CatalogPage submit() {
        submitButton.click();
        timeout(3);
        return PageFactory.initElements(modalDriver, CatalogPage.class);
    }
}