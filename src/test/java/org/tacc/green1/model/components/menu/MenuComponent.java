package org.tacc.green1.model.components.menu;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.DriverManager;
import org.tacc.green1.util.XPath;


public class MenuComponent extends Component implements XPath.Header.Menu {
    @FindBy(xpath = WOMEN_ARROW)
    private WebElement womenCategoryArrow;

    @FindBy(xpath = WOMEN_ITEM)
    private WebElement womenItem;

    @FindBy(xpath = MEN_ITEM)
    public WebElement menItem;


    public MenuComponent(SearchContext context) {
        super(context);
        timeoutByVisibility(5, womenCategoryArrow);
    }

    public WomenCategoryPopup openWomenCategoryPopup() {
        DriverManager.getActions()
                .moveToElement(womenItem)
                .perform();

        return new WomenCategoryPopup(context);
    }

    public MenCategoryPopup openMenCategoryPopup() {
        DriverManager.getActions()
                .moveToElement(menItem)
                .perform();

        return new MenCategoryPopup(context);
    }
}