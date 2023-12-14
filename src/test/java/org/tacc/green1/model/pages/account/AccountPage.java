package org.tacc.green1.model.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.XPath;


public class AccountPage extends Page implements XPath.AccountPage {
    @FindBy(xpath = CONTACT_INFORMATION_TEXT)
    private WebElement contactInfoTextElement;

    @FindBy(css = "span[class='base']")
    private WebElement welcomeTextElement;

    @FindBy(xpath = ACCOUNT_SIDEBAR)
    private WebElement accountSidebarBlock;


    public AccountPage() {
        timeoutByVisibility(contactInfoTextElement);
    }


    public String getAccountContactInfoText() {
        return contactInfoTextElement.getText();
    }

    public String getAccountPageWelcomeText() {
        return welcomeTextElement.getText();
    }

    public AccountSidebar gotoAccountSidebar() {
        return new AccountSidebar(accountSidebarBlock);
    }
}