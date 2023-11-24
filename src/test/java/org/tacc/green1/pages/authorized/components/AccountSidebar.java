package org.tacc.green1.pages.authorized.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.AccountInformationPage;
import org.tacc.green1.pages.Modal;

import static org.tacc.green1.util.XPath.AccountSidebar.ACCOUNT_INFORMATION_LINK;

public class AccountSidebar extends Modal {
    @FindBy(xpath = ACCOUNT_INFORMATION_LINK)
    private WebElement accountInformationLink;

    public AccountInformationPage gotoAccountInformationPage() {
        accountInformationLink.click();
        return PageFactory.initElements(modalDriver, AccountInformationPage.class);
    }
}
