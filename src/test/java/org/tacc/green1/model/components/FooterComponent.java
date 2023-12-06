package org.tacc.green1.model.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.AdvancedSearchPage;
import org.tacc.green1.util.XPath;

public class FooterComponent extends Component implements XPath.Footer {
    @FindBy(xpath = LINK_ADVANCED_SEARCH)
    private WebElement advancedSearchLink;

    public AdvancedSearchPage gotoAdvancedSearchPage() {
        advancedSearchLink.click();
        return new AdvancedSearchPage();
    }
}
