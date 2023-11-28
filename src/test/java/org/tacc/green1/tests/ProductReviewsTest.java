package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.catalog.ProductReviewsTab;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductReviewsTest {
    private static ProductReviewsTab productReviewsTab;


    @BeforeEach
    public void prepare() {
        productReviewsTab = MainPage.openBrowser()
                .gotoMainMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage()
                .getVisibleProductCards()
                .get(0)
                .gotoProductPage()
                .gotoProductReviewsTab();
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
                .submit()
                .timeout(4);

        assertEquals(expectedToPass, productReviewsTab.isReviewSubmitted());
    }


    @AfterEach
    public void finish() {
        productReviewsTab.quitDriver();
    }
}