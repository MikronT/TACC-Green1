package com.parasoft.parabank;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.parasoft.parabank.utils.PropertiesInitializer.getPath;
import static com.parasoft.parabank.utils.PropertiesInitializer.initialize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateUserInfoTest {
    static ChromeDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static Properties parabankProps = initialize(getPath("parabank.properties"));
    static Properties testAccountProps = initialize(getPath("testAccountInfo.properties"));
    static Properties updateUserProps = initialize(getPath("updateUserFieldNames.properties"));

    @BeforeAll
    public static void login() {
        driver.get(parabankProps.getProperty("main-page-link"));
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys(testAccountProps.getProperty("username"));
        password.sendKeys(testAccountProps.getProperty("password"));

        driver.findElement(By.xpath(parabankProps.getProperty("login-button-xpath"))).click();
        wait.until(d -> ExpectedConditions.visibilityOfAllElements());
        driver.findElement(By.xpath(parabankProps.getProperty("update-info-button-xpath"))).click();
    }

    @BeforeEach
    public void navigateToUpdatePage() {
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.xpath(parabankProps.getProperty("update-info-button-xpath"))));
        driver.findElement(By.xpath(parabankProps.getProperty("update-info-button-xpath"))).click();
    }

    @AfterAll
    public static void logout() {
        driver.findElement(By.xpath(parabankProps.getProperty("update-info-button-xpath"))).click();

        updateUserProps.forEach((key, value) -> driver.findElement(By.name(value.toString())).sendKeys(testAccountProps.getProperty(key.toString())));
        driver.findElement(By.xpath(parabankProps.getProperty("update-button-xpath"))).click();
        driver.findElement(By.xpath(parabankProps.getProperty("logout-button-xpath"))).click();
        driver.quit();
    }

    @Test
    @Order(1)
    public void changeCurrentData() {
        List<WebElement> formFields = new ArrayList<>();

        updateUserProps.forEach((key, value) -> formFields.add(driver.findElement(By.name(value.toString()))));
        formFields.forEach(element -> assertTrue(element.isDisplayed()));
        formFields.forEach(element -> element.sendKeys(element.getAttribute("value").toLowerCase() + "updated"));
        formFields.getFirst().submit();

        driver.findElement(By.xpath(parabankProps.getProperty("update-button-xpath"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("profile-updated-xpath"))));
        assertTrue(driver.findElement(By.xpath(parabankProps.getProperty("profile-updated-xpath"))).isDisplayed());
    }

    @Test
    @Order(2)
    public void verifyChanges() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("welcome-text-xpath"))));
        assertEquals(" updated", driver.findElement(By.xpath(parabankProps.getProperty("welcome-text-xpath"))).getAttribute("value"));
    }
}

