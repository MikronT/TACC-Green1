package org.tacc.green1.pages.authorized.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.Modal;
import org.tacc.green1.util.XPath;


    @FindBy(css = "button.action.switch")
    WebElement customerMenuToggle;

public class AccountPopup extends Modal<AccountPopup> implements XPath.AccountModal {
    @FindBy(xpath = MY_ACCOUNT_OPTION)
    WebElement myAccountModalOption;

    @FindBy(xpath = MY_WISH_LIST_OPTION)
    WebElement wishListModalOption;

    @FindBy(xpath = SIGN_OUT_OPTION)
    WebElement signOutModalOption;

    public AccountModal openModal() {
        customerMenuToggle.click();
        return this;
    }

    public AccountPage gotoAccountPage() {
        myAccountModalOption.click();
        return PageFactory.initElements(modalDriver, AccountPage.class);
    }

    public MainPage signOut() {
        signOutModalOption.click();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }
}