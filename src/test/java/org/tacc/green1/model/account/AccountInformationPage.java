package org.tacc.green1.model.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.Modal;


public class AccountInformationPage extends Modal<AccountInformationPage> {
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

    //TODO 25.11.2023: Refactor this method once again
    @SuppressWarnings("unchecked")
    public <T extends Modal<T>> T submit() {
        saveButton.click();

        if (isEmailToggled)
            return (T) signOut();

        return (T) this;
    }

    public LoginPage signOut() {
        return PageFactory.initElements(modalDriver, LoginPage.class);
    }
}