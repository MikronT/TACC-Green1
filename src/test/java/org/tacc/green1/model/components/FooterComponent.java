package org.tacc.green1.model.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.AdvancedSearchPage;
import org.tacc.green1.util.XPath;


public class FooterComponent extends Component implements XPath.Footer {
    @FindBy(xpath = LINK_ADVANCED_SEARCH)
    private WebElement advancedSearchLink;


    public FooterComponent(SearchContext context) {
        super(context);
    }


    public AdvancedSearchPage gotoAdvancedSearchPage() {
        advancedSearchLink.click();
        return new AdvancedSearchPage();
    }
}