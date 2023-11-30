package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tacc.green1.model.RegistrationPage;
import org.tacc.green1.util.RandomData;
import org.tacc.green1.util.TestClient;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest {
    private static RegistrationPage registrationPage;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        registrationPage = mainPage.gotoRegistrationPage();
    }


    private static Stream<Arguments> provideRegistrationData() {
        String firstName = RandomData.name();
        String lastName = RandomData.name();
        String email = RandomData.email();
        String password = RandomData.password();

        return Stream.of(
                Arguments.of(firstName, lastName, email, password)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRegistrationData")
    public void registerSuccessfully(String firstName,
                                     String lastName,
                                     String email,
                                     String password) {
        var accountPage = registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(password)
                .submit();

        assertEquals("My Account", accountPage.getAccountPageWelcomeText(),
                "Registration failed");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}