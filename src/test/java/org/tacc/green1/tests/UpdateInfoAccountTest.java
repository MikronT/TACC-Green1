package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.pages.AccountInformationPage;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.MainPage;

import static org.tacc.green1.util.Utils.sleep;


public class UpdateInfoAccountTest {
    private static AccountInformationPage accountInformationPage;

    @BeforeAll
    static void prepare() {
        MainPage mainPage = MainPage
                .initPage()
                .open()
                .gotoLoginPage()
                .fillEmail("volodymyr.nakonechnyi@gmail.com")
                .fillPassword("Fw35tgvAXypdEgfX6YuyUW")
                .submit();

        sleep(3);

        accountInformationPage = mainPage
                .gotoAccountPage("volodymyr.nakonechnyi@gmail.com")
                .gotoAccountInformationPage();

        sleep(3);
    }

    @ParameterizedTest
    @CsvSource({
            "Dodo,Uran,volodymyr.nakonechnyi@gmail.com,Fw35tgvAXypdEgfX6YuyUW",
    })
    void updatePublicInfoWithEmail(String firstName, String lastName, String email, String password) {
        String expectedResult = firstName + " " + lastName + '\n' + email;
        accountInformationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .toggleEmailCheckBox()
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        sleep(2);
        // After this action, we've logged out automatically

        MainPage mainPage = accountInformationPage
                .logout()
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        sleep(3);

        AccountPage accountPage = mainPage.gotoAccountPage(email);

        Assertions.assertEquals("My Account", accountPage.getAccountPageWelcomeText());
        Assertions.assertEquals(expectedResult, accountPage.getAccountContactInfoText());
    }

    @AfterAll
    public static void finish() {
        accountInformationPage.quit();
        //TODO: Короче, я не довбу, що ви там за цей час написали. Уже 1 ночі і я замахався, тому сорян)
    }
}