package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class WomenCategoryPopup extends Modal<WomenCategoryPopup> implements XPath.HeaderMenu {
    @FindBy(xpath = OPTION_WOMEN_TOPS)
    private WebElement womenTopsCategoryItem;


    public CatalogPage gotoWomenTopsCatalogPage() {
        timeoutByVisibility(womenTopsCategoryItem);

        womenTopsCategoryItem.click();
        return new CatalogPage();
    }
}