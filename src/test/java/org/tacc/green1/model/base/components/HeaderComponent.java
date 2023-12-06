package org.tacc.green1.model.base.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.RegistrationPage;
import org.tacc.green1.model.account.AccountPopup;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.util.XPath;

public class HeaderComponent extends Component implements XPath.Header, XPath.Header.HeaderMenu {
    private static final Logger LOG = LogManager.getLogger(HeaderComponent.class);

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

    public org.tacc.green1.model.menu.HeaderMenu gotoHeaderMenu() {
        return new org.tacc.green1.model.menu.HeaderMenu();
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

    public Cart openCart() {
        openCart.click();
        return new Cart();
    }
}
