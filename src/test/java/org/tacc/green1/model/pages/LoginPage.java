package org.tacc.green1.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tacc.green1.model.Modal;


public class LoginPage extends Modal {
    private static final By INPUT_EMAIL = By.cssSelector("[name=\"login\\[username\\]\"]");
    private static final By INPUT_PASSWORD = By.cssSelector("[name=\"login\\[password\\]\"]");
    private static final By BUTTON_SUBMIT = By.id("send2");

    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillEmail(String email) {
        modalDriver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        modalDriver.findElement(INPUT_PASSWORD).sendKeys(password);
        return this;
    }

    public MainPage submit() {
        modalDriver.findElement(BUTTON_SUBMIT).click();
        return new MainPage(modalDriver);
    }

    @Override
    public void quit() {
        modalDriver.quit();
    }
}