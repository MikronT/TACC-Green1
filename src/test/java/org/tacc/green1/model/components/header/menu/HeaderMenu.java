package org.tacc.green1.model.components.header.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.DriverManager;
import org.tacc.green1.util.XPath;


public class HeaderMenu extends Component implements XPath.Header.Menu {
    @FindBy(xpath = OPTION_WOMEN_ARROW)
    private WebElement womenCategoryArrow;

    @FindBy(xpath = OPTIOM_WOMEN_ITEM)
    private WebElement womenMenuItem;

    @FindBy(xpath = OPTION_MEN_ITEM)
    public WebElement menMenuItem;


    public HeaderMenu() {
        timeoutByVisibility(5, womenCategoryArrow);
    }

    public WomenCategoryPopup openWomenCategoryPopup() {
        DriverManager.getActions()
                .moveToElement(womenMenuItem)
                .perform();

        return new WomenCategoryPopup();
    }

    public MenCategoryPopup openMenCategoryPopup() {
        DriverManager.getActions()
                .moveToElement(menMenuItem)
                .perform();

        return new MenCategoryPopup();
    }
}