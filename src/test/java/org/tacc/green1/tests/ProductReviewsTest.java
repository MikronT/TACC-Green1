package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.catalog.ProductPage;
import org.tacc.green1.model.pages.catalog.ProductReviewsTab;
import org.tacc.green1.util.TestClient;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductReviewsTest extends BaseTest {
    private static Page page;
    private ProductPage productPage;
    private ProductReviewsTab productReviewsTab;


    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @BeforeEach
    public void prepare() {
        var catalogPage = page
                .gotoMenuComponent()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        var visibleProductCardsList = catalogPage.getVisibleProductCards();
        var random = new Random();
        var randomProductCard = visibleProductCardsList.get(random.nextInt(0, visibleProductCardsList.size()));

        productPage = randomProductCard.gotoProductPage();

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
                .fillRatingBar(rating)
                .fillNickName(nickName)
                .fillSummary(summary)
                .fillReview(review)
                .submit();

        assertEquals(expectedToPass, productPage.isReviewSubmitted(),
                "Posting the review didn't go as expected");
    }
}