package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.cart.Cart;
import org.tacc.green1.model.catalog.CatalogPage;
import org.tacc.green1.model.catalog.ProductCard;


public class DeleteProductFromCartTest {
    private static CatalogPage catalogPage;

    @BeforeAll
    public static void prepare() {
        catalogPage = MainPage
                .initPage()
                .open()
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();
    }


    @ParameterizedTest
    @CsvSource("Red,32")
    public void test1(String color, int size) {
        ProductCard card = catalogPage.getVisibleProductCards().get(0);

        card
                .chooseColor(color)
                .chooseSize(size)
                .submit()
                .timeout(3);

        Cart cart = catalogPage.initCart();
        cart
                .open()
                .getVisibleCartItems()
                .get(0)
                .deleteItemFromCart()
                .timeout(2)
                .confirmDelete()
                .timeout(2);


        Assertions.assertEquals(0, cart.getVisibleCartItems().size());
    }


    @AfterAll
    public static void finish() {
        catalogPage.quit();
    }
}