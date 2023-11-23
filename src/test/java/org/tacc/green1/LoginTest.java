package org.tacc.green1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tacc.green1.util.Utils.sleep;


public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;


    @BeforeAll
    public static void prepare() {
        driver = new ChromeDriver();
        loginPage = MainPage.open(driver).gotoLoginPage();
    }


    @ParameterizedTest
    @CsvSource({
            "teeest@eeeeeemail.com, a@nMttMMD9dzDx9",
    })
    public void loginTest(String email, String password) {
        MainPage finalPage = loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        sleep(3);

        assertTrue(finalPage.isLoggedIn());
    }

    @AfterAll
    public static void finish() {
        driver.quit();
    }
}