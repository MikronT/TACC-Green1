package org.tacc.green1.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.pages.LoginPage;
import org.tacc.green1.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tacc.green1.util.TestData.RegisteredTestUser.email;
import static org.tacc.green1.util.TestData.RegisteredTestUser.password;
import static org.tacc.green1.util.Utils.sleep;


public class LoginTest {
    private static final Logger LOG = LogManager.getLogger(LoginTest.class);
    private static LoginPage loginPage;


    @BeforeAll
    public static void prepare() {
        var page = MainPage.initPage().open();
        loginPage = page.gotoLoginPage();
        LOG.info("Preparation successful!");
    }


    @Test
    public void loginTest() {
        var mainPage = loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        sleep(3);

        assertTrue(mainPage.isLoggedIn());
    }

    @AfterAll
    public static void finish() {
        LOG.info("Test finished");
        loginPage.quit();
    }
}