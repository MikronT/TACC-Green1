package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.AdvancedSearchPage;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.RegistrationPage;
import org.tacc.green1.model.account.AccountPopup;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.model.menu.HeaderMenu;
import org.tacc.green1.util.XPath;


public abstract class Page<T> extends Modal implements XPath.Page {
    private static final Logger LOG = LogManager.getLogger(Page.class);

    @FindBy(xpath = LINK_LOGO)
    private WebElement logoLink;

    @FindBy(className = "authorization-link")
    private WebElement loginLink;

    @FindBy(xpath = LINK_REGISTRATION)
    private WebElement createAccountLink;

    @FindBy(xpath = LINK_WELCOME_ACCOUNT)
    private WebElement welcomeAccountLink;

    @FindBy(css = "button.action.switch")
    private WebElement accountPopupToggle;

    @FindBy(xpath = BUTTON_OPEN_CART)
    private WebElement openCart;

    @FindBy(xpath = LINK_ADVANCED_SEARCH)
    private WebElement advancedSearchLink;

    @FindBy(xpath = BUTTON_CONFIRM_DELETE)
    private WebElement confirmDeleteButton;


    public MainPage gotoMainPage() {
        logoLink.click();
        return new MainPage();
    }

    public LoginPage gotoLoginPage() {
        loginLink.click();
        return new LoginPage();
    }

    public RegistrationPage gotoRegistrationPage() {
        createAccountLink.click();
        return new RegistrationPage();
    }

    public AccountPopup openAccountPopup() {
        if (!isClientLoggedIn()) {
            String message = "No user is logged in, check out your method call order";
            LOG.error(message);
            throw new IllegalStateException(message);
        }

        accountPopupToggle.click();
        return new AccountPopup();
    }

    public HeaderMenu gotoHeaderMenu() {
        return new HeaderMenu();
    }

    public Cart openCart() {
        openCart.click();
        return new Cart();
    }

    public AdvancedSearchPage gotoAdvancedSearchPage() {
        advancedSearchLink.click();
        return new AdvancedSearchPage();
    }

    @SuppressWarnings("unchecked")
    public T confirmDelete() {
        timeoutByVisibility(confirmDeleteButton);

        confirmDeleteButton.click();

        timeout(3);
        return (T) this;
    }


    public boolean isClientLoggedIn() {
        try {
            timeoutByVisibility(welcomeAccountLink);
        } catch (TimeoutException e) {
            //Element not found, not logged in
            LOG.warn("The user is not logged in", e);
            return false;
        }

        var message = welcomeAccountLink.getText();
        //Manual welcome message check
        return message.contains("Welcome, ");
    }
}