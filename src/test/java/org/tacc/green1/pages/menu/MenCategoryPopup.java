package org.tacc.green1.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.Modal;
import org.tacc.green1.pages.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class MenCategoryPopup extends Modal<MenCategoryPopup> implements XPath.MainMenu {
    @FindBy(xpath = MENU_ITEM_MEN_BOTTOMS)
    private WebElement menBottomsCategoryItem;


    public CatalogPage gotoMenBottomsCatalogPage() {
        menBottomsCategoryItem.click();
        return PageFactory.initElements(modalDriver, CatalogPage.class);
    }
}