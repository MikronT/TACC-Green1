package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.XPath;

public class AccountPage extends Modal implements XPath.AccountSelect {
    @FindBy(xpath = SIGN_OUT_OPTION)
    private WebElement signOutModalOption;

    @FindBy(xpath = MY_WISH_LIST_OPTION)
    private WebElement wishListModalOption;

    @FindBy(xpath = MY_ACCOUNT_OPTION)
    private WebElement myAccountModalOption;

    @FindBy(css = "span[class='base']")
    private WebElement welcomeTextElement;

    @FindBy(css = "button.action.switch")
    private WebElement modalMenuToggle;

    public MainPage logout() {
        modalMenuToggle.click();
        signOutModalOption.click();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }

    public String getAccountPageWelcomeText() {
        return welcomeTextElement.getText();
    }
}
