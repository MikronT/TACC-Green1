package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountInformationPage extends Modal {
    private Boolean isEmailToggled = false;

    @FindBy(css = "#form-validate > div > div.primary > button")
    private WebElement saveButton;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "current-password")
    private WebElement currentPasswordInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "change-password")
    private WebElement changePasswordCheckBox;

    @FindBy(id = "change-email")
    private WebElement changeEmailCheckbox;

    public AccountPage gotoAccountPage() {
        return PageFactory.initElements(modalDriver, AccountPage.class);
    }

    public AccountInformationPage toggleEmailCheckBox() {
        changeEmailCheckbox.click();
        isEmailToggled = true;
        return this;
    }

    public AccountInformationPage togglePasswordCheckBox() {
        changePasswordCheckBox.click();
        return this;
    }

    public AccountInformationPage fillFirstName(String newFirstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(newFirstName);
        return this;
    }

    public AccountInformationPage fillLastName(String newLastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(newLastName);
        return this;
    }

    public AccountInformationPage fillEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public AccountInformationPage fillPassword(String password) {
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys(password);
        return this;
    }

    public AccountInformationPage fillConfirmPassword(String confirmationPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmationPassword);
        return this;
    }

    // TODO: refactor this method
    public <T extends Modal> T submit() {
        saveButton.click();
        if (isEmailToggled) {
            logout();
            return (T)PageFactory.initElements(modalDriver, LoginPage.class);
        }
        return (T)this;
    }

    public LoginPage logout() {
        return PageFactory.initElements(modalDriver, LoginPage.class);
    }
}