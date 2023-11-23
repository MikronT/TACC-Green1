package org.tacc.green1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.XPath;

public class RegistrationPage extends Modal implements XPath.Registration {
    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "email_address")
    public WebElement emailAddressInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    public WebElement confirmPasswordInput;

    @FindBy(css = "button[class$='primary'] span")
    public WebElement createAccountButton;

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

    public MainPage submit() {
        createAccountButton.click();
        return PageFactory.initElements(modalDriver, MainPage.class);
    }
}
