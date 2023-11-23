package org.tacc.green1.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tacc.green1.model.Modal;
import org.tacc.green1.util.XPath;

public class RegistrationPage extends Modal implements XPath.Registration {
    private static final By FIRST_NAME = By.xpath(INPUT_FIRST_NAME);
    private static final By LAST_NAME = By.xpath(INPUT_LAST_NAME);
    private static final By EMAIL = By.xpath(INPUT_EMAIL);
    private static final By PASSWORD = By.xpath(INPUT_PASSWORD);
    private static final By CONFIRM_PASSWORD = By.xpath(INPUT_CONFIRM_PASSWORD);
    private static final By SUBMIT = By.xpath(INPUT_SUBMIT_BUTTON);

    protected RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillFirstName(String firstName) {
        modalDriver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        modalDriver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        modalDriver.findElement(EMAIL).sendKeys(email);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        modalDriver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public RegistrationPage fillConfirmPassword(String password) {
        modalDriver.findElement(CONFIRM_PASSWORD).sendKeys(password);
        return this;
    }

    public MainPage submit() {
        modalDriver.findElement(SUBMIT).click();
        return new MainPage(modalDriver);
    }

    @Override
    protected void quit() {
        modalDriver.quit();
    }
}
