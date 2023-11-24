package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.pages.authorized.components.AccountModal;
import org.tacc.green1.pages.authorized.components.AccountSidebar;
import org.tacc.green1.util.XPath;


public class AccountPage extends Modal implements XPath.AccountModal, XPath.AccountProfile {

    @FindBy(xpath = CONTACT_INFORMATION_TEXT)
    private WebElement contactInfoTextElement;

    @FindBy(css = "span[class='base']")
    private WebElement welcomeTextElement;

    public MainPage logout() {
        getAccountModal().signOut();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }

    public String getAccountContactInfoText() {
        return contactInfoTextElement.getText();
    }

    public String getAccountPageWelcomeText() {
        return welcomeTextElement.getText();
    }

    private AccountModal getAccountModal() {
        return PageFactory.initElements(modalDriver, AccountModal.class);
    }

    private AccountSidebar getAccountSidebar() {
        return PageFactory.initElements(modalDriver, AccountSidebar.class);
    }

    public AccountInformationPage gotoAccountInformationPage() {
        getAccountSidebar().gotoAccountInformationPage();
        return PageFactory.initElements(modalDriver, AccountInformationPage.class);
    }
}