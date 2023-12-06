package org.tacc.green1.model.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.MainPage;
import org.tacc.green1.util.XPath;


public class AccountPopup extends Component implements XPath.AccountPopup {
    @FindBy(xpath = OPTION_MY_ACCOUNT)
    private WebElement myAccountOption;

    @FindBy(xpath = OPTION_MY_WISH_LIST)
    private WebElement myWishListOption;

    @FindBy(xpath = OPTION_SIGN_OUT)
    private WebElement signOutOption;

    public AccountPage gotoMyAccountPage() {
        myAccountOption.click();
        return new AccountPage();
    }

    public MainPage signOut() {
        signOutOption.click();
        return new MainPage();
    }
}