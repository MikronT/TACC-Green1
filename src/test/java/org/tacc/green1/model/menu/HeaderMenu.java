package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.util.Actor;
import org.tacc.green1.util.XPath;


public class HeaderMenu extends Modal<HeaderMenu> implements XPath.HeaderMenu {
    @FindBy(xpath = OPTION_WOMEN_ARROW)
    private WebElement womenCategoryArrow;

    @FindBy(xpath = OPTION_WOMEN_LINK)
    private WebElement womenCategoryItem;

    @FindBy(xpath = OPTION_MEN_LINK)
    private WebElement menCategoryItem;


    public HeaderMenu() {
        //Hardcoded timeout
        timeout(1);
    }


    public WomenCategoryPopup openWomenCategoryPopup() {
        timeoutByVisibility(womenCategoryItem);

        Actor.getActions()
                .moveToElement(womenCategoryItem)
                .build()
                .perform();
        return new WomenCategoryPopup();
    }

    public MenCategoryPopup openMenCategoryPopup() {
        timeoutByVisibility(menCategoryItem);

        Actor.getActions()
                .moveToElement(menCategoryItem)
                .build()
                .perform();
        return new MenCategoryPopup();
    }
}