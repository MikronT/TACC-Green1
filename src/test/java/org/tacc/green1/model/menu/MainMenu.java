package org.tacc.green1.model.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;
import org.tacc.green1.util.XPath;


public class MainMenu extends Modal<MainMenu> implements XPath.MainMenu {
    @FindBy(xpath = MENU_ITEM_WOMEN_LINK)
    private WebElement womenCategoryItem;

    @FindBy(xpath = MENU_ITEM_MEN_LINK)
    private WebElement menCategoryItem;


    public WomenCategoryPopup openWomenCategoryPopup() {
        modalActions()
                .moveToElement(womenCategoryItem)
                .build()
                .perform();
        return PageFactory.initElements(modalDriver, WomenCategoryPopup.class);
    }

    public MenCategoryPopup openMenCategoryPopup() {
        modalActions()
                .moveToElement(menCategoryItem)
                .build()
                .perform();
        return PageFactory.initElements(modalDriver, MenCategoryPopup.class);
    }
}