package org.tacc.green1.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tacc.green1.model.Modal;
import org.tacc.green1.util.XPath;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;


public class MainPage extends Modal implements XPath.MainPage {
    private static final Properties PROPS = initializeLocalProperties("website.properties");
    private static final By LINK_LOGIN = By.className("authorization-link");
    private static final By REGISTRATION = By.xpath(LINK_REGISTRATION);
    private static final By WELCOME_MESSAGE = By.xpath(WELCOME_MESSAGE_MAIN_PAGE);

    protected MainPage(WebDriver driver) {
        super(driver);
        driver.get(PROPS.getProperty("url"));
    }

    public static MainPage open(String browser) {
        return new MainPage(initialize(browser));
    }


    public LoginPage gotoLoginPage() {
        modalDriver.findElement(LINK_LOGIN).click();
        return new LoginPage(modalDriver);
    }

    public RegistrationPage gotoRegistrationPage() {
        modalDriver.findElement(REGISTRATION).click();
        return new RegistrationPage(modalDriver);
    }

    public boolean isLoggedIn() {
        try {
            var message = modalDriver.findElement(WELCOME_MESSAGE).getText();
            //Manual welcome message check
            return message.contains("Welcome, ");
        } catch (Exception ignored) {
            //Element not found, not logged in
            return false;
        }
    }

    @Override
    protected void quit() {
        modalDriver.quit();
    }
}