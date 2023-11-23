package org.tacc.green1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.Utils;
import org.tacc.green1.util.XPath;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;
import static org.tacc.green1.util.Utils.sleep;


public class MainPage extends Modal implements XPath.MainPage {
    private static final Properties PROPS = initializeLocalProperties("website.properties");

    //@FindBy(className = "authorization-link")
    //WebElement LINK_LOGIN;
    private static final By LINK_LOGIN = By.className("authorization-link");
    private static final By REGISTRATION = By.xpath(LINK_REGISTRATION);
    private static final By WELCOME_MESSAGE = By.xpath(WELCOME_MESSAGE_MAIN_PAGE);

    public MainPage() {
        super();
    }

    public static MainPage initPage() {
        modalDriver = Utils.initDriver();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }

    public MainPage open() {
        modalDriver.get(PROPS.getProperty("url"));
        return this;
    }


    public LoginPage gotoLoginPage() {
        modalDriver.findElement(LINK_LOGIN).click();
        return new LoginPage();
    }

    public RegistrationPage gotoRegistrationPage() {
        modalDriver.findElement(REGISTRATION).click();
        return new RegistrationPage();
    }

    public AccountPage gotoAccountPage(String email, String password) {
        gotoLoginPage().fillEmail(email).fillPassword(password).submit();
        AccountPage.gotoAccountPage();
        return new AccountPage();
    }

    public AccountInformationPage gotoAccountInformationPage(String email, String password) {
        gotoLoginPage().fillEmail(email).fillPassword(password).submit();
        sleep(3);
        AccountPage.gotoAccountPage();
        AccountInformationPage.gotoAccountInformationPage();
        return new AccountInformationPage();
    }

    public boolean isLoggedIn() {
        try {
            var message = modalDriver.findElement(WELCOME_MESSAGE).getText();
            //Manual welcome message check
            return message.contains("Welcome, ");
        } catch (Exception ignored) {
            //Element not found, not logged in
            return false;
        }
    }
}