package org.tacc.green1.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.Modal;
import org.tacc.green1.pages.catalog.WomenTopsCatalogPage;
import org.tacc.green1.util.XPath;


public class WomenCategoryPopup extends Modal<WomenCategoryPopup> implements XPath.MainMenu {
    @FindBy(xpath = MENU_ITEM_WOMEN_TOPS)
    private WebElement womenTopsCategoryItem;


    public WomenTopsCatalogPage gotoWomenTopsCatalogPage() {
        womenTopsCategoryItem.click();
        return PageFactory.initElements(modalDriver, WomenTopsCatalogPage.class);
    }
}