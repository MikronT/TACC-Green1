package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.RegistrationPage;

public class RegistrationTest {
    private static RegistrationPage registrationPage;
    private static AccountPage accountPage;

    @BeforeEach
    public void prepare() {
        registrationPage = MainPage.initPage().open().gotoRegistrationPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registrationData.csv")
    void registration(String firstName, String lastName, String email, String password, String confirmPassword) {
        accountPage = registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .submit();

        Assertions.assertEquals("My Account", accountPage.getAccountPageWelcomeText());
    }

    @AfterEach
    public void finish() {
        accountPage.logout();
    }

    @AfterAll
    public static void cleanup() {
        accountPage.quit();
    }
}
