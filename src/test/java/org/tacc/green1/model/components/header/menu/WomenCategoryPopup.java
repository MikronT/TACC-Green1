package org.tacc.green1.model.components.header.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class WomenCategoryPopup extends Component implements XPath.Header.HeaderMenu {
    @FindBy(xpath = OPTION_WOMEN_TOPS)
    private WebElement womenTopsCategoryItem;

    public CatalogPage gotoWomenTopsCatalogPage() {
        timeoutByVisibility(womenTopsCategoryItem);

        womenTopsCategoryItem.click();
        return new CatalogPage();
    }
}