package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.model.components.header.cart.Cart;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeleteProductFromCartTest extends BaseTest {
    private static CatalogPage catalogPage;

    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoMenuComponent()
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
        Cart cart = catalogPage
                .gotoHeaderComponent()
                .openCart();

        cart
                .getVisibleCartItems()
                .get(0)
                .deleteItemFromCart()
                .confirmDelete();

        assertEquals(0, cart.getVisibleCartItems().size(),
                "Couldn't delete product from the cart");
    }
}