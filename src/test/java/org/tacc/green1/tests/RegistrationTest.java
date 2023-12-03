package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tacc.green1.model.RegistrationPage;
import org.tacc.green1.util.TestClient;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest extends BaseTest {
    private static RegistrationPage registrationPage;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        registrationPage = mainPage.gotoRegistrationPage();
    }


    private static Stream<Arguments> provideRegistrationData() {
        var testClient = TestClient.generateRandomNewClient();

        return Stream.of(Arguments.of(
                testClient.getFirstName(),
                testClient.getLastName(),
                testClient.getEmail(),
                testClient.getPassword()));
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

        new TestClient()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .save();
    }
}