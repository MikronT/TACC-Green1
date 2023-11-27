package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.AccountInformationPage;
import org.tacc.green1.model.AccountPage;
import org.tacc.green1.model.LoginPage;
import org.tacc.green1.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateInfoAccountTest {
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;


    @SuppressWarnings("SpellCheckingInspection")
    @BeforeAll
    static void prepare() {
        accountInformationPage = MainPage.initPage().open()
                .gotoLoginPage()
                .fillEmail("volodymyr.nakonechnyi@gmail.com")
                .fillPassword("Fw35tgvAXypdEgfX6YuyUW")
                .submit()

                .timeout(3)
                .openAccountPopup()
                .gotoMyAccountPage()
                .gotoAccountInformationPage();
    }


    @SuppressWarnings("SpellCheckingInspection")
    @ParameterizedTest
    @CsvSource({
            "Dodo,Uran,volodymyr.nakonechnyi@gmail.com,Fw35tgvAXypdEgfX6YuyUW",
    })
    void updatePublicInfoWithEmail(String firstName, String lastName, String email, String password) {
        accountPage = accountInformationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .toggleEmailCheckBox()
                .fillEmail(email)
                .fillPassword(password)
                .<LoginPage>submit()

                .timeout(2)
                .fillEmail(email)
                .fillPassword(password)
                .submit()

                .timeout(3)
                .openAccountPopup()
                .gotoMyAccountPage();

        assertEquals("My Account", accountPage.getAccountPageWelcomeText());

        String expectedResult = firstName + " " + lastName + '\n' + email;
        assertEquals(expectedResult, accountPage.getAccountContactInfoText());
    }


    @AfterAll
    public static void finish() {
        accountPage.quit();
    }
}