package org.tacc.green1.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.authorized.components.AccountModal;
import org.tacc.green1.pages.search.AdvancedSearchPage;
import org.tacc.green1.util.Utils;
import org.tacc.green1.util.XPath;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;


public class MainPage extends Modal implements XPath.MainPage {
    private static final Logger LOG = LogManager.getLogger(MainPage.class);
    private static final Properties PROPS = initializeLocalProperties("website.properties");

    @FindBy(className = "authorization-link")
    private WebElement loginLink;

    @FindBy(xpath = LINK_REGISTRATION)
    private WebElement createAccountLink;

    @FindBy(xpath = WELCOME_MESSAGE_MAIN_PAGE)
    private WebElement welcomeAccountLink;
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


    public AccountPage gotoAccountPage(String email) {
        String message = String.format("user %s is not logged in, check out your method call order", email);

        if (isLoggedIn()) {
            LOG.info(String.format("user %s is logged in", email));
            return getAccountModal()
                    .openModal()
                    .gotoMyAccount();
        }

        LOG.error(message);
        throw new IllegalStateException(message);
    }

    public AdvancedSearchPage gotoAdvancedSearchPage() {
        advancedSearchLink.click();
        return PageFactory.initElements(modalDriver, AdvancedSearchPage.class);
    }

    private AccountModal getAccountModal() {
        return PageFactory.initElements(modalDriver, AccountModal.class);
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