package com.parasoft.parabank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ParabankUtils {
    private static WebDriverWait wait;

    private ParabankUtils() {
    }

    private static void waitInitializer(RemoteWebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public static RemoteWebDriver login(RemoteWebDriver driver, String url, String login, String password, String loginButtonXpath) {
        waitInitializer(driver);
        driver.get(url);

        WebElement usernameElement = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));

        usernameElement.sendKeys(login);
        passwordElement.sendKeys(password);

        driver.findElement(By.xpath(loginButtonXpath)).click();
        wait.until(d -> ExpectedConditions.visibilityOfAllElements());

        return driver;
    }

    public static RemoteWebDriver logout(RemoteWebDriver driver, String logoutButtonXpath) {
        waitInitializer(driver);

        driver.findElement(By.xpath(logoutButtonXpath)).click();
        return driver;
    }

    public static RemoteWebDriver addAccount(RemoteWebDriver driver) {


        return driver;
    }
}
