package com.parasoft.parabank.user;

import com.parasoft.parabank.utils.ParabankUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.parasoft.parabank.utils.PropertiesInitializer.getPath;
import static com.parasoft.parabank.utils.PropertiesInitializer.initialize;

public class FundsTransferTest {
    static ChromeDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static Properties parabankProps = initialize(getPath("parabank.properties"));
    static Properties testAccountProps = initialize(getPath("testAccountInfo.properties"));
    static int accountNumber;

    @BeforeAll
    public static void setup() {
        driver = (ChromeDriver) ParabankUtils.login(
                driver,
                parabankProps.getProperty("main-page-link"),
                testAccountProps.getProperty("username"),
                testAccountProps.getProperty("password"),
                parabankProps.getProperty("login-button-xpath"));

        driver.findElement(By.xpath(parabankProps.getProperty("open-new-account-button-xpath"))).click();
        driver.findElement(By.xpath(parabankProps.getProperty("open-new-account-submit-button-xpath"))).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        accountNumber = Integer.getInteger(driver.findElement(By.xpath(parabankProps.getProperty("new-account-id-xpath"))).getText());
        driver.findElement(By.xpath(parabankProps.getProperty("account-overview-button-xpath"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(parabankProps.getProperty("account-overview-account-number-xpath"))));
    }

    @BeforeEach
    public void localSetup() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parabankProps.getProperty("transfer-submit-button-xpath"))));
        driver.findElement(By.xpath(parabankProps.getProperty("transfer-funds-button-xpath"))).click();
    }

    @AfterAll
    public static void cleanup() {
        ParabankUtils.logout(driver, parabankProps.getProperty("logout-button-xpath"));
    }

    @Test
    public void transferFundsToSameAccountTest() {
        WebElement amount = driver.findElement(By.xpath(parabankProps.getProperty("transfer-amount-input-xpath")));
        amount.sendKeys("100");
        amount.submit();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        Assertions.assertTrue(driver.findElement(By.xpath(parabankProps.getProperty("transfer-funds-error-xpath"))).isDisplayed());
    }


    @Test
    public void transferFundsToAnotherAccountTest() {

    }

    @Test
    public void transferInsufficientFundsTest() {

    }
}
