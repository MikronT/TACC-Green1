package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.authorized.components.AccountSidebar;
import org.tacc.green1.util.XPath;


public class AccountPage extends Modal<AccountPage> implements XPath.AccountPage {
    @FindBy(xpath = CONTACT_INFORMATION_TEXT)
    private WebElement contactInfoTextElement;

    @FindBy(css = "span[class='base']")
    private WebElement welcomeTextElement;


    public String getAccountContactInfoText() {
        return contactInfoTextElement.getText();
    }

    public String getAccountPageWelcomeText() {
        return welcomeTextElement.getText();
    }

    private AccountSidebar getAccountSidebar() {
        return PageFactory.initElements(modalDriver, AccountSidebar.class);
    }

    public AccountInformationPage gotoAccountInformationPage() {
        return getAccountSidebar()
                .gotoAccountInformationPage();
    }
}