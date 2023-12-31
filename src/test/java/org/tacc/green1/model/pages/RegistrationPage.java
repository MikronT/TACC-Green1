package org.tacc.green1.model.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.account.AccountPage;


public class RegistrationPage extends Page {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailAddressInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(css = "button[class$='primary'] span")
    private WebElement createAccountButton;


    public RegistrationPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        emailAddressInput.sendKeys(email);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage fillConfirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public AccountPage submit() {
        createAccountButton.click();
        return new AccountPage();
    }
}