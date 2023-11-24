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
    private static AccountPage accountPage;
    private static AccountInformationPage accountInformationPage;

    @BeforeAll
    static void prepare() {
        accountInformationPage = MainPage.initPage().open()
                .gotoAccountInformationPage("volodymyr.nakonechnyi@gmail.com", "Fw35tgvAXypdEgfX6YuyUW");
    }

    @ParameterizedTest
    @CsvSource({
            "Dodo,Uran,volodymyr.nakonechnyi@gmail.com,Fw35tgvAXypdEgfX6YuyUW",
    })
    void updateAllPublicInfo(String firstName, String lastName, String email, String password) {
        accountInformationPage
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .toggleEmailCheckBox()
                .inputEmail(email)
                .inputPassword(password)
                .submitNewUserInfo();

        sleep(2);

        accountPage = MainPage.initPage().open()
                .gotoAccountPage(email, password);

        String expectedResult = firstName + " " + lastName + '\n' + email;

        System.out.println(accountPage.getAccountContactInfoText());

        Assertions.assertEquals(expectedResult, accountPage.getAccountContactInfoText());
    }

    @AfterAll
    public static void finish() {
        //TODO: Короче, я не довбу, що ви там за цей час написали. Уже 1 ночі і я замахався, тому сорян)
        accountInformationPage.quit();
        accountPage.quit();
    }
}