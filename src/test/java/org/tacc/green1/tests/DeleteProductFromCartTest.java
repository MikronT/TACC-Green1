package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.model.cart.CartItem;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.util.TestClient;
import org.tacc.green1.util.XPath;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tacc.green1.util.XPath.CartItem.CONFIRM_DELETE_BUTTON;


public class DeleteProductFromCartTest implements XPath.Cart {
    private static CatalogPage catalogPage;


    @BeforeAll
    public static void prepare() {
        var mainPage = TestClient.openBrowser();

        catalogPage = mainPage
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        var productCard = catalogPage.getVisibleProductCards().get(0);

        productCard.chooseColor("Red")
                .chooseSize(32)
                .submitAddToCart()
                .timeoutByLocator(By.xpath(SUCCESS_ADDED_ITEM_CART));
    }


    @Test
    public void deleteProductFromCartTest() {
        Cart cart = catalogPage.openCart();

        List<CartItem> cartItems = cart
                .timeoutByLocator(By.xpath(ITEMS))
                .getVisibleCartItems();

        cartItems.get(0)
                .deleteItemFromCart()
                .timeoutByLocator(By.xpath(CONFIRM_DELETE_BUTTON))
                .confirmDelete()
                .timeoutByLocator(By.xpath(EMPTY_CART_TEXT));

        assertEquals(0, cartItems.size(),
                "Couldn't delete product from the cart");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}