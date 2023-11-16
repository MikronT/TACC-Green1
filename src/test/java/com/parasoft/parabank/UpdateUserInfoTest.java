package com.parasoft.parabank;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static com.parasoft.parabank.utils.PropertiesInitializer.getPath;
import static com.parasoft.parabank.utils.PropertiesInitializer.initialize;
import static org.junit.jupiter.api.Assertions.*;

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
    }

    @BeforeEach
    public void navigateToUpdatePage() {
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.xpath(parabankProps.getProperty("update-info-button-xpath"))));
        driver.findElement(By.xpath(parabankProps.getProperty("update-info-button-xpath"))).click();
    }

    @AfterAll
    public static void logout() {
        driver.findElement(By.xpath(parabankProps.getProperty("update-info-button-xpath"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("update-form-xpath"))));
        updateUserProps.forEach((key, value) -> driver.findElement(By.name(value.toString())).sendKeys(testAccountProps.getProperty(key.toString())));
        driver.findElement(By.xpath(parabankProps.getProperty("update-button-xpath"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("profile-updated-xpath"))));
        driver.findElement(By.xpath(parabankProps.getProperty("logout-button-xpath"))).click();
        driver.quit();
    }

    @Test
    @Order(1)
    public void updateCurrentData() {
        updateUserProps.forEach((key, value) -> {
            WebElement element = driver.findElement(By.name(value.toString()));
            assertTrue(element.isDisplayed());
            element.sendKeys(element.getText().toLowerCase() + " updated");

        });
        driver.findElement(By.xpath(parabankProps.getProperty("update-button-xpath"))).submit();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("profile-updated-xpath"))));
        assertTrue(driver.findElement(By.xpath(parabankProps.getProperty("profile-updated-xpath"))).isDisplayed());
    }

    @Test
    @Order(2)
    public void changesSavedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("welcome-text-xpath"))));
        System.out.println();
        assertEquals("Welcome updated updated", driver.findElement(By.xpath(parabankProps.getProperty("welcome-text-xpath"))).getText());
    }

    @Test
    @Order(2)
    public void changesSavedUnsuccessfully() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("welcome-text-xpath"))));
        assertNotEquals("Welcome updated updated", driver.findElement(By.xpath(parabankProps.getProperty("welcome-text-xpath"))).getText());
    }
}

