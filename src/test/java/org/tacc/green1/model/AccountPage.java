package org.tacc.green1.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tacc.green1.util.XPath;

public class AccountPage extends Modal implements XPath.AccountSelect, XPath.AccountProfile {
    private static final By ACCOUNT_SELECT = By.xpath(ACCOUNT_SELECT_BUTTON);
    private static final By MY_ACCOUNT = By.xpath(MY_ACCOUNT_OPTION);
    private static final By MY_WISH_LIST = By.xpath(MY_WISH_LIST_OPTION);
    private static final By SING_OUT = By.xpath(SIGN_OUT_OPTION);
    private static final By MY_ACCOUNT_TEXT = By.xpath(MY_ACCOUNT_WELCOME_TEXT);
    protected AccountPage(WebDriver driver) {
        super(driver);
    }

    public static void logout(WebDriver driver) {
        driver.findElement(ACCOUNT_SELECT).click();
        driver.findElement(SING_OUT).click();
    }

    public static String AccountPageWelcomeText(WebDriver driver) {
        return driver.findElement(MY_ACCOUNT_TEXT).getText();
    }
}
