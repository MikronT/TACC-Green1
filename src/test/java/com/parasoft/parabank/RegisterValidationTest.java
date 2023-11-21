package com.parasoft.parabank;

import com.parasoft.parabank.model.AdminPage;
import com.parasoft.parabank.model.RegistrationPage;
import com.parasoft.parabank.model.utils.XPath;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;


public class RegisterValidationTest {
    private static final WebDriver driver = new ChromeDriver();
    static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static final HashMap<String, String> registrationFormFields = new HashMap<>();
    static final HashMap<String, String> validUserProps = new HashMap<>();

    public RegisterValidationTest() {
        registrationFormFields.put("firstName", "customer.firstName");
        registrationFormFields.put("lastName", "customer.lastName");
        registrationFormFields.put("address", "customer.address.street");
        registrationFormFields.put("city", "customer.address.city");
        registrationFormFields.put("state", "customer.address.state");
        registrationFormFields.put("zipCode", "customer.address.zipCode");
        registrationFormFields.put("phone", "customer.phoneNumber");
        registrationFormFields.put("ssn", "customer.ssn");
        registrationFormFields.put("username", "customer.username");
        registrationFormFields.put("password", "customer.password");
        registrationFormFields.put("repeatedPassword", "repeatedPassword");

        validUserProps.put("firstName", "Volodymyr");
        validUserProps.put("lastName", "Nakonechnyi");
        validUserProps.put("address", "Boolean Street 28/16");
        validUserProps.put("city", "San-Francisco");
        validUserProps.put("state", "California");
        validUserProps.put("zipCode", "94112");
        validUserProps.put("phone", "19512390523");
        validUserProps.put("ssn", "078051120");
        validUserProps.put("username", "VolodymyrNak");
        validUserProps.put("password", "L27{>mm^wAN437P.;UHH");
        validUserProps.put("repeatedPassword", "L27{>mm^wAN437P.;UHH");
    }

    @BeforeAll
    public static void openPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        wait.until(d -> ExpectedConditions.visibilityOfElementLocated(By.id("mainPanel")));
    }

    @AfterAll
    static void logout() {
        new AdminPage(driver)
                .open()
                .cleanDatabase();
        driver.quit();
    }

    @Test
    @Order(2)
    void register() {
        new RegistrationPage(driver).fillRegistrationForm(validUserProps).submitRegistrationForm();

        WebElement successRegister = driver.findElement(By.xpath(XPath.RegisterPage.successRegisterText));

        Assertions.assertEquals("Your account was created successfully. You are now logged in.", successRegister.getText());

        WebElement logout = driver.findElement(By.xpath(XPath.Logout.logoutButton));
        logout.click();
    }

    @Test
    @Order(3)
    void login() {
        WebElement username = driver.findElement(By.xpath(XPath.Login.usernameInput));
        WebElement password = driver.findElement(By.xpath(XPath.Login.passwordInput));
        WebElement loginButton = driver.findElement(By.xpath(XPath.Login.loginButton));

        username.sendKeys(validUserProps.get("username"));
        password.sendKeys(validUserProps.get("password"));

        loginButton.click();

        WebElement successLogin = driver.findElement(By.xpath(XPath.Login.successLogin));

        Assertions.assertEquals("Account Services", successLogin.getText());
    }
}