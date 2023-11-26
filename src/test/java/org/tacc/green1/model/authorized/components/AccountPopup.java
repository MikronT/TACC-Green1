package org.tacc.green1.model.authorized.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.AccountPage;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.Modal;
import org.tacc.green1.util.XPath;


public class AccountPopup extends Modal<AccountPopup> implements XPath.AccountModal {
    @FindBy(xpath = MY_ACCOUNT_OPTION)
    private WebElement myAccountModalOption;

    @FindBy(xpath = MY_WISH_LIST_OPTION)
    private WebElement wishListModalOption;

    @FindBy(xpath = SIGN_OUT_OPTION)
    private WebElement signOutModalOption;


    public AccountPage gotoAccountPage() {
        myAccountModalOption.click();
        return PageFactory.initElements(modalDriver, AccountPage.class);
    }

    public MainPage signOut() {
        signOutModalOption.click();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }
}