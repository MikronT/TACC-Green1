package org.tacc.green1.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.tacc.green1.util.PropertiesInitializer.initializeLocalProperties;


public class MainPage extends Modal {
    private static final Properties PROPS = initializeLocalProperties("website.properties");
    private static final By LINK_LOGIN = By.className("authorization-link");
    private static final By LINK_REGISTRATION = By.xpath("[class=\"header links\"]/li[3]");
    private static final By WELCOME_MESSAGE = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");


    protected MainPage(WebDriver driver) {
        super(driver);
        driver.get(PROPS.getProperty("url"));
    }

    public static MainPage open(WebDriver driver) {
        return new MainPage(driver);
    }


    public LoginPage gotoLoginPage() {
        driver.findElement(LINK_LOGIN).click();
        return new LoginPage(driver);
    }

    public LoginPage gotoRegistrationPage() {
        driver.findElement(LINK_REGISTRATION).click();
        return new LoginPage(driver);
    }


    public boolean isLoggedIn() {
        try {
            var message = driver.findElement(WELCOME_MESSAGE).getText();
            //Manual welcome message check
            return message.contains("Welcome, ");
        } catch (Exception ignored) {
            //Element not found, not logged in
            return false;
        }
    }
}