package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.pages.AccountInformationPage;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.LoginPage;
import org.tacc.green1.pages.MainPage;

public class UpdateInfoAccountTest {
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;

    @BeforeAll
    static void prepare() {
        accountInformationPage = MainPage
                .initPage()
                .open()
                .gotoLoginPage()
                .fillEmail("volodymyr.nakonechnyi@gmail.com")
                .fillPassword("Fw35tgvAXypdEgfX6YuyUW")
                .submit()
                .timeout(3).redirect(MainPage.class)
                .gotoAccountPage("volodymyr.nakonechnyi@gmail.com")
                .gotoAccountInformationPage();
    }

    @ParameterizedTest
    @CsvSource({
            "Dodo,Uran,volodymyr.nakonechnyi@gmail.com,Fw35tgvAXypdEgfX6YuyUW",
    })
    void updatePublicInfoWithEmail(String firstName, String lastName, String email, String password) {
        String expectedResult = firstName + " " + lastName + '\n' + email;
        accountPage = accountInformationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .toggleEmailCheckBox()
                .fillEmail(email)
                .fillPassword(password)
                .submit()
                .timeout(2).redirect(LoginPage.class)
                .fillEmail(email)
                .fillPassword(password)
                .submit()
                .timeout(3).redirect(MainPage.class)
                .gotoAccountPage(email);

        Assertions.assertEquals("My Account", accountPage.getAccountPageWelcomeText());
        Assertions.assertEquals(expectedResult, accountPage.getAccountContactInfoText());
    }

    @AfterAll
    public static void finish() {
        accountInformationPage.quit();
        accountPage.quit();
    }
}