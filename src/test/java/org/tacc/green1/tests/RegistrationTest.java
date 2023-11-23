package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.LoginPage;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.RegistrationPage;
import org.tacc.green1.util.TestData;

import java.util.stream.Stream;

public class RegistrationTest {
    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;

    static Stream<Arguments> provideLoginValues() {
        return Stream.of(
                Arguments.of(TestData.RegisteredTestUser.email, TestData.RegisteredTestUser.password)
        );
    }

    @BeforeEach
    public void prepare() {
        registrationPage = MainPage.initPage().open().gotoRegistrationPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registrationData.csv")
    void registration(String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .submit();

        Assertions.assertEquals("My Account", AccountPage.getAccountPageWelcomeText());

        AccountPage.logout();
    }

    @ParameterizedTest
    @MethodSource("provideLoginValues")
    void login(String email, String password) {
        loginPage = MainPage.initPage().open().gotoLoginPage();
        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        Assertions.assertEquals("My Account", AccountPage.getAccountPageWelcomeText());
    }

    @AfterEach
    public void finish() {
        loginPage.quit();
    }
}
