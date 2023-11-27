package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class MenCategoryPopup extends Modal<MenCategoryPopup> implements XPath.MainMenu {
    @FindBy(xpath = OPTION_MEN_BOTTOMS)
    private WebElement menBottomsCategoryItem;


    public CatalogPage gotoMenBottomsCatalogPage() {
        menBottomsCategoryItem.click();
        return PageFactory.initElements(modalDriver, CatalogPage.class);
    }
}