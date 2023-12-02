package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class MenCategoryPopup extends Modal<MenCategoryPopup> implements XPath.HeaderMenu {
    @FindBy(xpath = OPTION_MEN_BOTTOMS)
    private WebElement menBottomsCategoryItem;


    public CatalogPage gotoMenBottomsCatalogPage() {
        timeoutByVisibility(menBottomsCategoryItem);

        menBottomsCategoryItem.click();
        return new CatalogPage();
    }
}