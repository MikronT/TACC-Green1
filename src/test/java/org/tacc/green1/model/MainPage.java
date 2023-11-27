package org.tacc.green1.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.account.AccountPopup;
import org.tacc.green1.model.menu.MainMenu;
import org.tacc.green1.model.search.AdvancedSearchPage;
import org.tacc.green1.util.Utils;
import org.tacc.green1.util.XPath;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;


public class MainPage extends Modal<MainPage> implements XPath.MainPage {
    private static final Logger LOG = LogManager.getLogger(MainPage.class);
    private static final Properties PROPS = initializeLocalProperties("website.properties");

    @FindBy(className = "authorization-link")
    private WebElement loginLink;

    @FindBy(xpath = LINK_REGISTRATION)
    private WebElement createAccountLink;

    @FindBy(xpath = LINK_WELCOME_ACCOUNT)
    private WebElement welcomeAccountLink;

    @FindBy(css = "button.action.switch")
    private WebElement accountPopupToggle;

    @FindBy(xpath = LINK_ADVANCED_SEARCH)
    private WebElement advancedSearchLink;


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

    public AccountPopup openAccountPopup() {
        if (isLoggedIn()) {
            accountPopupToggle.click();
            return PageFactory.initElements(modalDriver, AccountPopup.class);
        }

        String message = "No user is not logged in, check out your method call order";
        LOG.error(message);
        throw new IllegalStateException(message);
    }

    public MainMenu gotoMainMenu() {
        timeout(1);
        return PageFactory.initElements(modalDriver, MainMenu.class);
    }

    public AdvancedSearchPage gotoAdvancedSearchPage() {
        advancedSearchLink.click();
        return PageFactory.initElements(modalDriver, AdvancedSearchPage.class);
    }


    public boolean isLoggedIn() {
        try {
            var message = welcomeAccountLink.getText();
            //Manual welcome message check
            return message.contains("Welcome, ");
        } catch (Exception e) {
            //Element not found, not logged in
            LOG.warn("The user is not logged in", e);
            return false;
        }
    }
}