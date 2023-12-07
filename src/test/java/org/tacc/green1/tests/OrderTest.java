package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.model.pages.catalog.ProductCard;
import org.tacc.green1.util.TestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest extends BaseTest {
    private static CatalogPage catalogPage;
    private static List<ProductCard> visibleProductsCards;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoHeaderComponent()
                .gotoHeaderMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        visibleProductsCards = catalogPage.getVisibleProductCards();
    }


    @SuppressWarnings("SpellCheckingInspection")
    @ParameterizedTest
    @CsvSource({
            "Red, 33, 0, volodymyr.nakonechnyi28@gmail.com, Volodymyr, Nakonechnyi, SoftServe, Jourdano Bruno 80/17, Roma, Albania, B38097, Roma oblast, +14078032432"
    })
    public void orderTest(String color, int size, int productNumber, String email, String firstName, String lastName,
                          String company, String streetAddress, String city, String country, String postalCode,
                          String stateProvince, String phoneNumber) {
        var desiredProductCard = visibleProductsCards.get(productNumber);

        desiredProductCard
                .chooseSize(size)
                .chooseColor(color)
                .submitAddToCart();

        var cart = catalogPage.gotoHeaderComponent().openCart();

        var orderPage = cart
                .proceedToCheckout()
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
                .selectShippingMethod()
                .nextPage()
                .placeOrder();

        assertEquals("Thank you for your purchase!", orderPage.getThanksText(),
                "Order placed thanks text didn't match");
    }
}