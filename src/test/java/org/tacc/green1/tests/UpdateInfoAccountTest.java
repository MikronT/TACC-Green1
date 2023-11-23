package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.pages.AccountInformationPage;
import org.tacc.green1.pages.AccountPage;
import org.tacc.green1.pages.LoginPage;
import org.tacc.green1.pages.MainPage;

import java.time.LocalDate;

import static org.tacc.green1.util.Utils.sleep;

public class UpdateInfoAccountTest {
    private static AccountInformationPage accountInformationPage;
    @BeforeAll
    static void prepare() { accountInformationPage = MainPage.initPage().open().gotoAccountInformationPage("volodymyr.nakonechnyi@gmail.com","Fw35tgvAXypdEgfX6YuyUW"); }

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

        new MainPage().gotoAccountPage(email, password);

        String expectedResult = firstName + " " + lastName + '\n' + email;

        System.out.println(AccountPage.getAccountContactInfoText());

        Assertions.assertEquals(expectedResult, AccountPage.getAccountContactInfoText());
    }

    @AfterAll
    public static void finish() {
        //Короче, я не довбу, що ви там за цей час написали. Уже 1 ночі і я замахався, тому сорян)
        return;
    }
}
