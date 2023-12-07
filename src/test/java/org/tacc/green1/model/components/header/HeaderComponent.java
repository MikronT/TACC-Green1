package org.tacc.green1.model.components.header;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.components.header.cart.Cart;
import org.tacc.green1.model.pages.LoginPage;
import org.tacc.green1.model.pages.MainPage;
import org.tacc.green1.model.pages.RegistrationPage;
import org.tacc.green1.model.pages.account.AccountPopup;
import org.tacc.green1.util.XPath;


public class HeaderComponent extends Component implements XPath.Header {
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

    @FindBy(xpath = ACCOUNT_POPUP)
    private WebElement accountPopupBlock;

    @FindBy(xpath = BUTTON_OPEN_CART)
    private WebElement openCart;

    @FindBy(xpath = CART_LOADER)
    private WebElement cartLoader;

    @FindBy(xpath = CART)
    private WebElement cartBlock;


    public HeaderComponent(SearchContext context) {
        super(context);
    }


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
        return new AccountPopup(accountPopupBlock);
    }

    public Cart openCart() {
        //Try waiting for cart loader
        try {
            LOG.debug("Waiting for cart loader to appear");
            timeoutByVisibility(2, cartLoader);
            LOG.debug("Waiting for cart loader to disappear");
            timeoutByInvisibility(2, cartLoader);
            LOG.debug("Cart loader completed");
        } catch (TimeoutException e) {
            LOG.info("Probably, no cart loader ¯\\_(ツ)_/¯", e);
        }

        openCart.click();

        timeoutByVisibility(2, cartBlock);
        return new Cart(cartBlock);
    }
}