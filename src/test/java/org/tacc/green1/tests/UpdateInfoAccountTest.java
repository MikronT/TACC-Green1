package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.account.AccountInformationPage;
import org.tacc.green1.model.account.AccountPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateInfoAccountTest {
    private static MainPage mainPage;
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;
    private static String email, password;


    @BeforeAll
    public static void initClient() {
        mainPage = TestClient.openBrowserAndLogin();

        email = TestClient.getEmail();
        password = TestClient.getPassword();

        accountPage = mainPage
                .openAccountPopup()
                .gotoMyAccountPage();
    }

    @BeforeEach
    public void prepare() {
        accountInformationPage = accountPage
                .gotoAccountSidebar()
                .gotoAccountInformationPage();
    }


    @ParameterizedTest
    @CsvSource({
            "Dodo,Uran"
    })
    void updatePublicInfo(String firstName, String lastName) {
        var loginPage = accountInformationPage
                .fillNameForm(firstName, lastName)
                .toggleEmailCheckBox()
                .fillEmail(email)
                .fillPassword(password)
                .<LoginPage>submit()
                .timeout(3);

        loginPage
                .fillForm(email, password)
                .submit();

        mainPage.openAccountPopup()
                .gotoMyAccountPage();

        assertEquals("My Account", accountPage.getAccountPageWelcomeText(),
                "Logging in failed");

        String expectedResult = firstName + " " + lastName + '\n' + email;
        assertEquals(expectedResult, accountPage.getAccountContactInfoText(),
                "Public info didn't update successfully");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}