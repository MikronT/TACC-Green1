package org.tacc.green1.model.pages.account;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.XPath;


public class AccountSidebar extends Component implements XPath.AccountSidebar {
    @FindBy(xpath = LINK_ADDRESS_BOOK)
    private WebElement addressBookLink;

    @FindBy(xpath = LINK_ACCOUNT_INFORMATION)
    private WebElement accountInformationLink;


    protected AccountSidebar(SearchContext context) {
        super(context);
    }


    public AddressBookPage gotoAddressBookPage() {
        addressBookLink.click();
        return new AddressBookPage();
    }

    public AccountInformationPage gotoAccountInformationPage() {
        accountInformationLink.click();
        return new AccountInformationPage();
    }
}