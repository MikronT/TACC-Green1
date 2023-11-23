package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.RegistrationPage;
import org.tacc.green1.util.RegistrationDataWriter;

import java.util.stream.Stream;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest {
    private static RegistrationPage registrationPage;


    @BeforeAll
    public static void prepare() {
        RegistrationDataWriter.clear();

        registrationPage = MainPage.initPage().open().gotoRegistrationPage();
    }


    private static Stream<Arguments> provideRegistrationValues() {
        String firstName = randomAlphanumeric(5, 10).toLowerCase();
        String lastName = randomAlphanumeric(5, 10).toLowerCase();
        String email = (randomAlphanumeric(5, 10) + "@"
                + randomAlphanumeric(5, 10) + "."
                + randomAlphabetic(2, 3)).toLowerCase();
        String password = randomAscii(8, 16);

        return Stream.of(
                Arguments.of(firstName, lastName, email, password, password)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRegistrationValues")
    public void registration(String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .submit();

        assertEquals("My Account", AccountPage.getAccountPageWelcomeText());

        //Save registration data for future
        RegistrationDataWriter.append(firstName, lastName, email, password, confirmPassword);
    }


    @AfterAll
    public static void finish() {
        registrationPage.quit();
    }
}