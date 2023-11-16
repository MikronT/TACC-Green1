package com.parasoft.parabank;

import com.parasoft.parabank.utils.CleanDatabase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.parasoft.parabank.utils.PropertiesInitializer.getPath;
import static com.parasoft.parabank.utils.PropertiesInitializer.initialize;

public class RegisterValidation {
    private static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static HashMap<String, String> registrationFormFields = new HashMap<>();
    static HashMap<String, String> validUserProps  = new HashMap<>();

    public RegisterValidation () {
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
    public static void openPage () {
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
        WebElement firstName = driver.findElement(By.id(registrationFormFields.get("firstName")));
        WebElement lastName = driver.findElement(By.id(registrationFormFields.get("lastName")));
        WebElement address = driver.findElement(By.id(registrationFormFields.get("address")));
        WebElement city = driver.findElement(By.id(registrationFormFields.get("city")));
        WebElement state = driver.findElement(By.id(registrationFormFields.get("state")));
        WebElement zipCode = driver.findElement(By.id(registrationFormFields.get("zipCode")));
        WebElement phone = driver.findElement(By.id(registrationFormFields.get("phone")));
        WebElement ssn = driver.findElement(By.id(registrationFormFields.get("ssn")));
        WebElement username = driver.findElement(By.id(registrationFormFields.get("username")));
        WebElement password = driver.findElement(By.id(registrationFormFields.get("password")));
        WebElement confirmPassword = driver.findElement(By.id(registrationFormFields.get("repeatedPassword")));

        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input"));

        /*=======================================================================*/

        firstName.sendKeys(validUserProps.get("firstName"));
        lastName.sendKeys(validUserProps.get("lastName"));
        address.sendKeys(validUserProps.get("address"));
        city.sendKeys(validUserProps.get("city"));
        state.sendKeys(validUserProps.get("state"));
        zipCode.sendKeys(validUserProps.get("zipCode"));
        phone.sendKeys(validUserProps.get("phone"));
        ssn.sendKeys(validUserProps.get("ssn"));
        username.sendKeys(validUserProps.get("username"));
        password.sendKeys(validUserProps.get("password"));
        confirmPassword.sendKeys(validUserProps.get("repeatedPassword"));

        submit.click();

        WebElement successRegister = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));

        Assertions.assertEquals("Your account was created successfully. You are now logged in.", successRegister.getText());

        WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));
        logout.click();
    }

    @Test
    @Order(3)
    void login() {
        WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));

        username.sendKeys(validUserProps.get("username"));
        password.sendKeys(validUserProps.get("password"));

        loginButton.click();

        WebElement successLogin = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/h2"));

        Assertions.assertEquals("Account Services", successLogin.getText());

    }

}
