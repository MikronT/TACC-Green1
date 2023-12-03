package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.account.AccountInformationPage;
import org.tacc.green1.model.account.AccountPage;
import org.tacc.green1.util.TestClient;
import org.tacc.green1.util.XPath;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateInfoAccountTest implements XPath.AccountPage {
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;
    private static String email, password;


    @BeforeAll
    public static void initClient() {
        var testClient = TestClient.pickAnySavedUser();
        var mainPage = TestClient.openBrowserAndLogin(testClient);

        email = testClient.getEmail();
        password = testClient.getPassword();

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
                .<LoginPage>submit();

        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .submit();

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