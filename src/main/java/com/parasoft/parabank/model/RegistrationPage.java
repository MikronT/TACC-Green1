package com.parasoft.parabank.model;

import com.parasoft.parabank.model.utils.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class RegistrationPage extends Page<RegistrationPage> {
    private static final String PAGE_URL = "register.htm";

    private final By firstNameInput = By.id("customer.firstName");
    private final By lastNameInput = By.id("customer.lastName");
    private final By addressInput = By.id("customer.address.street");
    private final By cityInput = By.id("customer.address.city");
    private final By stateInput = By.id("customer.address.state");
    private final By zipCodeInput = By.id("customer.address.zipCode");
    private final By phoneInput = By.id("customer.phoneNumber");
    private final By ssnInput = By.id("customer.ssn");
    private final By usernameInput = By.id("customer.username");
    private final By passwordInput = By.id("customer.password");
    private final By confirmPasswordInput = By.id("repeatedPassword");
    private final By submitButton = By.xpath(XPath.RegisterPage.submitButton);
    private final By successRegisterText = By.xpath(XPath.RegisterPage.successRegisterText);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public String getLocalUrlPath () {
        return PAGE_URL;
    }

    public RegistrationPage fillRegistrationForm(HashMap<String, String> userData) {
        driver.findElement(firstNameInput).sendKeys(userData.get("firstName"));
        driver.findElement(lastNameInput).sendKeys(userData.get("lastName"));
        driver.findElement(addressInput).sendKeys(userData.get("address"));
        driver.findElement(cityInput).sendKeys(userData.get("city"));
        driver.findElement(stateInput).sendKeys(userData.get("state"));
        driver.findElement(zipCodeInput).sendKeys(userData.get("zipCode"));
        driver.findElement(phoneInput).sendKeys(userData.get("phone"));
        driver.findElement(ssnInput).sendKeys(userData.get("ssn"));
        driver.findElement(usernameInput).sendKeys(userData.get("username"));
        driver.findElement(passwordInput).sendKeys(userData.get("password"));
        driver.findElement(confirmPasswordInput).sendKeys(userData.get("repeatedPassword"));
        return this;
    }

    public RegistrationPage submitRegistrationForm() {
        driver.findElement(submitButton).click();
        return this;
    }

    public String getSuccessRegisterText() {
        return driver.findElement(successRegisterText).getText();
    }


}
