package org.tacc.green1.model.authorized.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.AccountInformationPage;
import org.tacc.green1.model.AddressBookPage;
import org.tacc.green1.model.Modal;


public class AccountSidebar extends Modal<AccountSidebar> {
    @FindBy(partialLinkText = "Address Book")
    private WebElement addressBookLink;

    @FindBy(partialLinkText = "Account Information")
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