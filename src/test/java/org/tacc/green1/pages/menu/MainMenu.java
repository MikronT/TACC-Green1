package org.tacc.green1.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.Modal;
import org.tacc.green1.util.XPath;


public class MainMenu extends Modal<MainMenu> implements XPath.MainMenu {
    @FindBy(xpath = MENU_ITEM_WOMEN_LINK)
    private WebElement womenCategoryItem;


    public WomenCategoryPopup openWomenCategoryPopup() {
        modalActions()
                .moveToElement(womenCategoryItem)
                .build()
                .perform();
        return PageFactory.initElements(modalDriver, WomenCategoryPopup.class);
    }
}