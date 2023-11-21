package com.parasoft.parabank;

import com.parasoft.parabank.model.utils.XPath;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static com.parasoft.parabank.model.utils.PropertiesInitializer.getPath;
import static com.parasoft.parabank.model.utils.PropertiesInitializer.initialize;
import static org.junit.jupiter.api.Assertions.*;


public class UpdateUserInfoTest {
    static final ChromeDriver driver = new ChromeDriver();
    static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static final Properties parabankProps = initialize(getPath("parabank.properties"));
    static final Properties testAccountProps = initialize(getPath("testAccountInfo.properties"));
    static final Properties updateUserProps = initialize(getPath("updateUserFieldNames.properties"));

    @BeforeAll
    public static void login() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys(testAccountProps.getProperty("username"));
        password.sendKeys(testAccountProps.getProperty("password"));

        driver.findElement(By.xpath(XPath.Login.loginButton)).click();
        wait.until(d -> ExpectedConditions.visibilityOfAllElements());
    }

    @BeforeEach
    public void navigateToUpdatePage() {
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath.UpdatePage.updateInfoButton)));
        driver.findElement(By.xpath(XPath.UpdatePage.updateInfoButton)).click();
    }

    @AfterAll
    public static void logout() {
        driver.findElement(By.xpath(XPath.UpdatePage.updateInfoButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(XPath.UpdatePage.updateForm)));
        updateUserProps.forEach((key, value) -> driver.findElement(By.name(value.toString())).sendKeys(testAccountProps.getProperty(key.toString())));
        driver.findElement(By.xpath(XPath.UpdatePage.updateButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(XPath.UpdatePage.profileUpdated)));
        driver.findElement(By.xpath(XPath.Logout.logoutButton)).click();
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
        driver.findElement(By.xpath(XPath.UpdatePage.updateButton)).submit();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(XPath.UpdatePage.profileUpdated)));
        assertTrue(driver.findElement(By.xpath(XPath.UpdatePage.profileUpdated)).isDisplayed());
    }

    @Test
    @Order(2)
    public void changesSavedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(XPath.UpdatePage.welcomeText)));
        System.out.println();
        assertEquals("Welcome updated updated", driver.findElement(By.xpath(XPath.UpdatePage.welcomeText)).getText());
    }

    @Test
    @Order(2)
    public void changesSavedUnsuccessfully() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(XPath.UpdatePage.welcomeText)));
        assertNotEquals("Welcome updated updated", driver.findElement(By.xpath(XPath.UpdatePage.welcomeText)).getText());
    }
}