package org.tacc.green1.model.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.util.XPath;


public class AccountSidebar extends Modal implements XPath.AccountSidebar {
    @FindBy(xpath = LINK_ADDRESS_BOOK)
    private WebElement addressBookLink;

    @FindBy(xpath = LINK_ACCOUNT_INFORMATION)
    private WebElement accountInformationLink;


    public AddressBookPage gotoAddressBookPage() {
        addressBookLink.click();
        return new AddressBookPage();
    }

    public AccountInformationPage gotoAccountInformationPage() {
        accountInformationLink.click();
        return new AccountInformationPage();
    }
}