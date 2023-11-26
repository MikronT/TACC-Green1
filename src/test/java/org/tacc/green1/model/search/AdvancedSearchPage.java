package org.tacc.green1.model.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;


public class AdvancedSearchPage extends Modal<AdvancedSearchPage> {
    @FindBy(id = "name")
    private WebElement productNameInput;

    @FindBy(css = "#form-validate > div > div > button")
    private WebElement submitButton;


    public AdvancedSearchPage fillProductName(String name) {
        productNameInput.sendKeys(name);
        return this;
    }

    public CatalogAdvancedSearchPage submit() {
        submitButton.click();
        return PageFactory.initElements(modalDriver, CatalogAdvancedSearchPage.class);
    }
}