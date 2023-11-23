package org.tacc.green1;

import com.sun.tools.javac.Main;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tacc.green1.model.AccountPage;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.RegistrationPage;
import org.tacc.green1.util.XPath;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RegistrationTest {
    private static WebDriver driver;
    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;
    private final String firstName = "Nikola";
    private final String lastName = "Tesla";
    private final String email = "nikola.tesla10@gmail.com";
    private final String password = "C>;\":decH9y|E/@m;3p~F94&vp";
    private final String confirmPassword = "C>;\":decH9y|E/@m;3p~F94&vp";
    @BeforeAll
    void prepare() {
        driver = new ChromeDriver();
        registrationPage = MainPage.open(driver).gotoRegistrationPage();
    }

    @ParameterizedTest
    @CsvSource({
            firstName, lastName, email, password, confirmPassword
    })
    @Order(1)
    void registration(String firstName, String lastName, String email, String password,String confirmPassword) {
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .submit();

        Assertions.assertEquals("My Account", AccountPage.AccountPageWelcomeText(driver));

        AccountPage.logout(driver);
    }

    @ParameterizedTest
    @CsvSource({
            firstName, lastName
    })
    @Order(2)
    void login(String firstName, String lastName) {
        loginPage = MainPage.open(driver).gotoLoginPage();

        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        Assertions.assertEquals("My Account", AccountPage.AccountPageWelcomeText(driver));
    }

    @AfterAll
    void finish() { driver.quit(); }
}
