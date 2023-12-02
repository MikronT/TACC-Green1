package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.model.cart.CartItem;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeleteProductFromCartTest {
    private static CatalogPage catalogPage;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoHeaderMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        var productCard = catalogPage.getVisibleProductCards().get(0);

        productCard
                .chooseColor("Red")
                .chooseSize(32)
                .submitAddToCart();
    }


    @Test
    public void deleteProductFromCartTest() {
        Cart cart = catalogPage.openCart();

        CartItem cartItem = cart.getVisibleCartItems().get(0);
        cartItem.deleteItemFromCart()
                .confirmDelete();

        assertEquals(0, cart.getVisibleCartItems().size(),
                "Couldn't delete product from the cart");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}