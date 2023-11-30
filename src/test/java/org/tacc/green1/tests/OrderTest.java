package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.model.catalog.ProductCard;
import org.tacc.green1.util.TestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest {
    private static CatalogPage catalogPage;
    private static List<ProductCard> visibleProductsCards;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        visibleProductsCards = catalogPage.getVisibleProductCards();
    }


    @SuppressWarnings("SpellCheckingInspection")
    @ParameterizedTest
    @CsvSource({
            "Red, 33, 0, volodymyr.nakonechnyi28@gmail.com, Volodymyr, Nakonechnyi, SoftServe, Jourdano Bruno 80/17, Roma, Albania, B38097, Roma oblast, +14078032432"
    })
    void orderTest(String color, int size, int productNumber, String email, String firstName, String lastName,
                   String company, String streetAddress, String city, String country, String postalCode,
                   String stateProvince, String phoneNumber) {
        var desiredProductCard = visibleProductsCards.get(productNumber);

        desiredProductCard
                .chooseSize(size)
                .chooseColor(color)
                .submitAddToCart()
                .timeout(3);

        var cart = catalogPage
                .openCart()
                .timeout(3);

        var orderPage = cart
                .proceedToCheckout()
                .timeout(3)
                .fillForm(
                        email, firstName, lastName,
                        company, streetAddress, city, country, postalCode,
                        stateProvince, phoneNumber)
                .timeout(4)
                .selectShippingMethod()
                .nextPage()
                .timeout(5)
                .placeOrder()
                .timeout(4);

        assertEquals("Thank you for your purchase!", orderPage.getThanksText(),
                "Order placed thanks text didn't match");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}