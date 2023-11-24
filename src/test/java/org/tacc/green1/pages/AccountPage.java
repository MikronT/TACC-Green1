package org.tacc.green1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.XPath;


public class AccountPage extends Modal implements XPath.AccountSelect, XPath.AccountProfile {
    private static final By ACCOUNT_SELECT = By.xpath(ACCOUNT_SELECT_BUTTON);
    private static final By MY_ACCOUNT = By.xpath(MY_ACCOUNT_OPTION);
    private static final By MY_WISH_LIST = By.xpath(MY_WISH_LIST_OPTION);
    private static final By SING_OUT = By.xpath(SIGN_OUT_OPTION);
    private static final By MY_ACCOUNT_TEXT = By.xpath(MY_ACCOUNT_WELCOME_TEXT);
    private static final By CONTACT_INFO = By.xpath(CONTACT_INFORMATION_TEXT);
    // @FindBy(xpath = CONTACT_INFORMATION_TEXT)
    // private static WebElement CONTACT_INFO;

    @FindBy(xpath = SIGN_OUT_OPTION)
    private WebElement signOutModalOption;

    @FindBy(xpath = MY_WISH_LIST_OPTION)
    private WebElement wishListModalOption;

    @FindBy(xpath = MY_ACCOUNT_OPTION)
    private static WebElement myAccountModalOption;

    @FindBy(css = "span[class='base']")
    private static WebElement welcomeTextElement;

    private static final By modalMenuToggle = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private static final By myAccountOption = By.xpath(MY_ACCOUNT_OPTION);

    //@FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button")
    //private static WebElement modalMenuToggle;

    //@FindBy(css = "button.action.switch")
    //private WebElement modalMenuToggle;

    public MainPage logout() {
        //modalMenuToggle.click();
        signOutModalOption.click();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }

    public static String getAccountContactInfoText() {
        return modalDriver.findElement(CONTACT_INFO).getText();
    }

    public String getAccountPageWelcomeText() {
        return modalDriver.findElement(MY_ACCOUNT_TEXT).getText();
    }

    public static void gotoAccountPage() {
        modalDriver.findElement(modalMenuToggle).click();
        modalDriver.findElement(myAccountOption).click();
    }
}