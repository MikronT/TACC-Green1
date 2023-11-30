package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeleteProductFromCartTest {
    private static CatalogPage catalogPage;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage()
                .showMaxProductsPerPage();
    }


    @ParameterizedTest
    @CsvSource("Red,32")
    public void test1(String color, int size) {
        var productCard = catalogPage.getVisibleProductCards().get(0);

        productCard.chooseColor(color)
                .chooseSize(size)
                .submitAddToCart()
                .timeout(3);

        Cart cart = catalogPage.openCart();

        cart.getVisibleCartItems().get(0)
                .deleteItemFromCart()
                .timeout(2)
                .confirmDelete()
                .timeout(2);

        assertEquals(0, cart.getVisibleCartItems().size(),
                "Couldn't delete product from the cart");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}