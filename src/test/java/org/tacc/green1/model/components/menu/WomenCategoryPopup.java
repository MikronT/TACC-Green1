package org.tacc.green1.model.components.menu;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class WomenCategoryPopup extends Component implements XPath.Header.Menu {
    @FindBy(xpath = WOMEN_TOPS)
    private WebElement womenTopsCategoryItem;


    protected WomenCategoryPopup(SearchContext context) {
        super(context);
    }


    public CatalogPage gotoWomenTopsCatalogPage() {
        timeoutByVisibility(womenTopsCategoryItem);

        womenTopsCategoryItem.click();
        return new CatalogPage();
    }
}