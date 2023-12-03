package org.tacc.green1.model.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.XPath;


public class AccountPage extends Page<AccountPage> implements XPath.AccountPage {
    @FindBy(xpath = CONTACT_INFORMATION_TEXT)
    private WebElement contactInfoTextElement;

    @FindBy(css = "span[class='base']")
    private WebElement welcomeTextElement;


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
        return new AccountSidebar();
    }
}