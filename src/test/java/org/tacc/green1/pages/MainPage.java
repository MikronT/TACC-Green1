package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.Utils;
import org.tacc.green1.util.XPath;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;

public class MainPage extends Modal implements XPath.MainPage {
    private static final Properties PROPS = initializeLocalProperties("website.properties");

    @FindBy(className = "authorization-link")
    private WebElement loginLink;

    @FindBy(xpath = LINK_REGISTRATION)
    private WebElement createAccountLink;

    @FindBy(xpath = WELCOME_MESSAGE_MAIN_PAGE)
    private WebElement welcomeAccountLink;

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
        loginLink.click();
        return PageFactory.initElements(modalDriver, LoginPage.class);
    }

    public RegistrationPage gotoRegistrationPage() {
        createAccountLink.click();
        return PageFactory.initElements(modalDriver, RegistrationPage.class);
    }

    public boolean isLoggedIn() {
        try {
            var message = welcomeAccountLink.getText();
            //Manual welcome message check
            return message.contains("Welcome, ");
        } catch (Exception ignored) {
            //Element not found, not logged in
            return false;
        }
    }
}