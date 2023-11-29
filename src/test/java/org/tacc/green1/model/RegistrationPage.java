package org.tacc.green1.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.account.AccountPage;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.TestClient;


public class RegistrationPage extends Page<RegistrationPage> {
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


    private void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        TestClient.setFirstName(firstName);
    }

    private void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        TestClient.setLastName(lastName);
    }

    private void fillEmail(String email) {
        emailAddressInput.sendKeys(email);
        TestClient.setEmail(email);
    }

    private void fillPassword(String password) {
        passwordInput.sendKeys(password);
        TestClient.setPassword(password);
    }

    private void fillConfirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
    }

    public RegistrationPage fillForm(String firstName,
                                     String lastName,
                                     String email,
                                     String password,
                                     String confirmPassword) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        return this;
    }

    public AccountPage submit() {
        createAccountButton.click();
        TestClient.save();
        return new AccountPage();
    }
}