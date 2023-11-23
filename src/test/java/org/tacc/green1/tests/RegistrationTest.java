package org.tacc.green1.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.LoginPage;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.RegistrationPage;

import java.util.stream.Stream;

import static org.tacc.green1.util.TestData.NewTestUser.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class RegistrationTest {
    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;

    static Stream<Arguments> provideLoginValues() {
        return Stream.of(
                Arguments.of(email, password)
        );
    }

    static Stream<Arguments> provideRegistrationValues() {
        return Stream.of(
                Arguments.of(firstName, lastName, email, password, confirmPassword)
        );
    }

    @BeforeAll
    static void prepare() {
        registrationPage = MainPage.initPage().open().gotoRegistrationPage();
    }

    @ParameterizedTest
    @MethodSource("provideRegistrationValues")
    @Order(1)
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
    @Order(2)
    void login(String email, String password) {
        loginPage = MainPage.initPage().open().gotoLoginPage();
        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        Assertions.assertEquals("My Account", AccountPage.getAccountPageWelcomeText());
    }

    @AfterAll
    static void finish() {
        loginPage.quit();
    }
}
