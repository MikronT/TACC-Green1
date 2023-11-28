package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.OrderPage;
import org.tacc.green1.model.catalog.CatalogPage;

public class OrderTest {
    private static CatalogPage catalogPage;

    @BeforeAll
    public static void prepare() {
        catalogPage = MainPage.initPage().open().gotoMainMenu().openMenCategoryPopup().gotoMenBottomsCatalogPage();
    }

    @ParameterizedTest
    @CsvSource({
            "Red, 33, 0, volodymyr.nakonechnyi28@gmail.com, Volodymyr, Nakonechnyi, SoftServe, Jourdano Bruno 80/17, Roma, Albania, B38097, Roma oblast, +14078032432"
    })
    void orderTest(String color, int size, int countProduct, String email, String firstName, String lastName,
                   String company, String streetAddress, String city, String country, String postalCode,
                   String stateProvince, String phoneNumber)
    {

        catalogPage.getVisibleProductCards()
                .get(countProduct)
                .chooseSize(size)
                .chooseColor(color)
                .submit()
                .timeout(3);

        catalogPage
                .initCart()
                .open()
                .timeout(3)
                .proceedToCheckout()
                .timeout(3)
                .enterEmail(email)
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterCompany(company)
                .enterStreetAddress(streetAddress)
                .enterCity(city)
                .selectCountry(country)
                .enterPostalCode(postalCode)
                .enterStateProvince(stateProvince)
                .enterPhoneNumber(phoneNumber)
                .timeout(4)
                .selectShippingMethod()
                .nextPage()
                .timeout(3)
                .placeOrder()
                .timeout(4);

        Assertions.assertEquals("Thank you for your purchase!", OrderPage.getThanksText());
    }

    @AfterAll
    public static void finish() {
        catalogPage.quit();
    }
}
