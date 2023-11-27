package org.tacc.green1.model.authorized.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.AccountInformationPage;
import org.tacc.green1.model.AddressBookPage;
import org.tacc.green1.model.Modal;
import org.tacc.green1.util.XPath;


public class AccountSidebar extends Modal<AccountSidebar> implements XPath.AccountSidebar {
    @FindBy(xpath = LINK_ADDRESS_BOOK)
    private WebElement addressBookLink;

    @FindBy(xpath = LINK_ACCOUNT_INFORMATION)
    private WebElement accountInformationLink;


    public AddressBookPage gotoAddressBookPage() {
        addressBookLink.click();
        return PageFactory.initElements(modalDriver, AddressBookPage.class);
    }

    public AccountInformationPage gotoAccountInformationPage() {
        accountInformationLink.click();
        return PageFactory.initElements(modalDriver, AccountInformationPage.class);
    }
}