package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.model.pages.catalog.ProductCard;
import org.tacc.green1.util.TestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToCartTest extends BaseTest {
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

    @ParameterizedTest
    @CsvSource({
            "Red, 33, 1"
    })
    public void addToCartTest(String color, int size, int productNumber) {
        var desiredProductCard = visibleProductsCards.get(productNumber);

        desiredProductCard
                .chooseSize(size)
                .chooseColor(color)
                .submitAddToCart();

        catalogPage.gotoHeaderComponent().openCart();
        var testClient = TestClient.generateRandomNewClient();
        testClient.register(catalogPage);
        var cart = catalogPage.gotoHeaderComponent().openCart();
        var added_el = cart.getVisibleCartItems().get(0);
        assertEquals(String.valueOf(productNumber), added_el.getQuantity(), "Quantity must match");
    }
}
