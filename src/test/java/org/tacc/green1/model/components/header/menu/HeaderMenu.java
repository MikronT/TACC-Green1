package org.tacc.green1.model.components.header.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.DriverManager;
import org.tacc.green1.util.XPath;


public class HeaderMenu extends Component implements XPath.Header.HeaderMenu {
    @FindBy(xpath = OPTION_WOMEN_ARROW)
    private WebElement womenCategoryArrow;

    @FindBy(xpath = OPTION_WOMEN_LINK)
    private WebElement womenCategoryItem;

    @FindBy(xpath = OPTION_MEN_LINK)
    private WebElement menCategoryItem;

    public HeaderMenu() {
        timeoutByVisibility(womenCategoryArrow);
        timeout(1);
    }

    public WomenCategoryPopup openWomenCategoryPopup() {
        timeoutByVisibility(womenCategoryItem);

        DriverManager.getActions()
                .moveToElement(womenCategoryItem)
                .build()
                .perform();
        return new WomenCategoryPopup();
    }

    public MenCategoryPopup openMenCategoryPopup() {
        timeoutByVisibility(menCategoryItem);

        DriverManager.getActions()
                .moveToElement(menCategoryItem)
                .build()
                .perform();
        return new MenCategoryPopup();
    }
}