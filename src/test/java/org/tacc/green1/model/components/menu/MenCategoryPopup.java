package org.tacc.green1.model.components.menu;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.util.XPath;


public class MenCategoryPopup extends Component implements XPath.Header.Menu {
    @FindBy(xpath = MEN_BOTTOMS)
    private WebElement menBottomsCategoryItem;


    protected MenCategoryPopup(SearchContext context) {
        super(context);
    }


    public CatalogPage gotoMenBottomsCatalogPage() {
        timeoutByVisibility(menBottomsCategoryItem);

        menBottomsCategoryItem.click();
        return new CatalogPage();
    }
}