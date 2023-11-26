package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class WomenCategoryPopup extends Modal<WomenCategoryPopup> implements XPath.MainMenu {
    @FindBy(xpath = MENU_ITEM_WOMEN_TOPS)
    private WebElement womenTopsCategoryItem;


    public CatalogPage gotoWomenTopsCatalogPage() {
        womenTopsCategoryItem.click();
        return PageFactory.initElements(modalDriver, CatalogPage.class);
    }
}