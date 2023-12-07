package org.tacc.green1.model.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.catalog.CatalogPage;


public class AdvancedSearchPage extends Page {
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

    public AdvancedSearchPage fillProductPriceTo(String price) {
        productPriceToInput.sendKeys(price);
        return this;
    }

    public CatalogPage submit() {
        submitButton.click();
        return new CatalogPage();
    }
}