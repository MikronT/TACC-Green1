package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.model.catalog.ProductCard;
import org.tacc.green1.util.TestClient;
import org.tacc.green1.util.XPath;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest implements XPath.Cart, XPath.OrderPage {
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
                .timeoutByLocator(By.xpath(SUCCESS_ADDED_ITEM_CART));

        var cart = catalogPage
                .openCart()
                .timeoutByLocator(By.xpath(ITEMS));

        var orderPage = cart
                .proceedToCheckout()
                .timeoutByLocator(By.xpath(EMAIL))
                .fillForm(
                        email, firstName, lastName,
                        company, streetAddress, city, country, postalCode,
                        stateProvince, phoneNumber)
                .timeoutByLocator(By.xpath(SHIPPING_METHOD))
                .selectShippingMethod()
                .nextPage()
                .timeoutByLocator(By.xpath(PLACE_ORDER_BUTTON))
                .placeOrder()
                .timeoutByLocator(By.xpath(CONTINUE_SHOPPING_BUTTON));

        assertEquals("Thank you for your purchase!", orderPage.getThanksText(),
                "Order placed thanks text didn't match");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}