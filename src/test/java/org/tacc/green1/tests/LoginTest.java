package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {
    private MainPage mainPage;
    private LoginPage loginPage;


    @BeforeEach
    public void prepare() {
        mainPage = MainPage.openBrowser();
        loginPage = mainPage.gotoLoginPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/registrationData.csv")
    public void loginTest(String ignoredFirstName,
                          String ignoredLastName,
                          String email,
                          String password,
                          String ignoredConfirmPassword) {
        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        assertTrue(mainPage.isClientLoggedIn());
    }


    @AfterEach
    public void finish() {
        mainPage.quitDriver();
    }
}