package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.LoginPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTest {
    private static Page<?> page;
    private LoginPage loginPage;

    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @BeforeEach
    public void prepare() {
        loginPage = page.gotoHeaderComponent().gotoLoginPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registrationData.csv")
    public void loginTest(String ignoredFirstName,
                          String ignoredLastName,
                          String email,
                          String password) {
        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        assertTrue(page.isClientLoggedIn(), "Logging in failed");
    }

    @AfterEach
    public void signOut() {
        page.gotoHeaderComponent().openAccountPopup().signOut();
    }
}