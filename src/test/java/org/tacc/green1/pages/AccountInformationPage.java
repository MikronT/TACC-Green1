package org.tacc.green1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInformationPage extends Modal {
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInputLocator = By.id("email");
    private By currentPasswordInput = By.id("current-password");
    private By newPasswordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By changeEmailCheckBox = By.id("change-email");
    private By changePasswordCheckBox = By.id("change-password");
    private By saveButton = By.cssSelector("#form-validate > div > div.primary > button");

    private static By accountInformationOption = By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[7]/a");

    public AccountInformationPage toggleEmailCheckBox() {
        modalDriver.findElement(changeEmailCheckBox).click();
        return this;
    }

    public AccountInformationPage togglePasswordCheckBox() {
        modalDriver.findElement(changePasswordCheckBox).click();
        return this;
    }

    public AccountInformationPage inputFirstName(String newfirstName) {
        WebElement firstName = modalDriver.findElement(firstNameInput);
        firstName.clear();
        firstName.sendKeys(newfirstName);
        return this;
    }

    public AccountInformationPage inputLastName(String newlastName) {
        WebElement lastName = modalDriver.findElement(lastNameInput);
        lastName.clear();
        lastName.sendKeys(newlastName);
        return this;
    }

    public AccountInformationPage inputEmail(String email) {
        WebElement emailInput = modalDriver.findElement(emailInputLocator);
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public AccountInformationPage inputPassword (String password) {
        WebElement currentPassword = modalDriver.findElement(currentPasswordInput);
        currentPassword.clear();
        currentPassword.sendKeys(password);
        return this;
    }

    public AccountInformationPage inputConfirmationPassword (String confirmationPassword) {
        WebElement confirmPassword = modalDriver.findElement(confirmPasswordInput);
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmationPassword);
        return this;
    }

    public AccountInformationPage submitNewUserInfo() {
        modalDriver.findElement(saveButton).click();
        return this;
    }

    public static void gotoAccountInformationPage() {
        modalDriver.findElement(accountInformationOption).click();
    }
}

