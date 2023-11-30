package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.catalog.ProductReviewsTab;
import org.tacc.green1.util.TestClient;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductReviewsTest {
    private static Page<?> page;
    private ProductReviewsTab productReviewsTab;


    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @BeforeEach
    public void prepare() {
        var catalogPage = page
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        var visibleProductCardsList = catalogPage.getVisibleProductCards();
        var random = new Random();
        var randomProductCard = visibleProductCardsList.get(random.nextInt(0, visibleProductCardsList.size()));

        var productPage = randomProductCard.gotoProductPage();

        productReviewsTab = productPage.gotoProductReviewsTab();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/productReviews.csv")
    public void writeReviewTest(boolean expectedToPass,
                                int rating,
                                String nickName,
                                String summary,
                                String review) {
        productReviewsTab
                .fillForm(rating, nickName, summary, review)
                .submit()
                .timeout(4);

        assertEquals(expectedToPass, productReviewsTab.isReviewSubmitted(),
                "Posting the review didn't go as expected");
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}