package org.tacc.green1.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.model.pages.LoginPage;
import org.tacc.green1.model.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tacc.green1.util.Utils.sleep;

import static org.tacc.green1.util.TestData.RegisteredTestUser.*;


public class LoginTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private static LoginPage loginPage;


    @BeforeAll
    public static void prepare() {
        loginPage = MainPage.open("chrome").gotoLoginPage();
        logger.info("Preparation successful!");
    }


    @Test
    public void loginTest() {
        MainPage finalPage = loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        sleep(3);

        assertTrue(finalPage.isLoggedIn());
    }

    @AfterAll
    public static void finish() {
        logger.info("Test finished");
        loginPage.quit();
    }
}