package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {
    private LoginPage loginPage;


    @BeforeEach
    public void prepare() {
        loginPage = MainPage.initPage().open().gotoLoginPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/registrationData.csv")
    public void loginTest(String ignoredFirstName,
                          String ignoredLastName,
                          String email,
                          String password,
                          String ignoredConfirmPassword) {
        assertTrue(loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit()
                .timeout(3)
                .isLoggedIn());
    }


    @AfterEach
    public void finish() {
        loginPage.quit();
    }
}