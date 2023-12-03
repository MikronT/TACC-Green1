package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.account.AccountInformationPage;
import org.tacc.green1.model.account.AccountPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateInfoAccountTest extends BaseTest {
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;
    private static String email, password;


    @BeforeAll
    public static void initClient() {
        var mainPage = TestClient.openBrowser();
        var testClient = TestClient.pickAnySavedKnownClient();
        testClient.login(mainPage);

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
}