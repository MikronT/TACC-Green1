package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.AdvancedSearchPage;
import org.tacc.green1.model.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdvancedSearchTest {
    private AdvancedSearchPage advancedSearchPage;


    @BeforeEach
    public void openAdvancedSearchPage() {
        advancedSearchPage = MainPage.initPage().open()
                .gotoAdvancedSearchPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/advancedSearchData.csv")
    public void advancedSearch(String productName,
                               String sku,
                               String description,
                               String shortDescription,
                               String fromPrice,
                               String toPrice,
                               String assertName) {
        assertTrue(advancedSearchPage
                .fillProductName(productName)
                .fillProductSKU(sku)
                .fillProductDescription(description)
                .fillProductShortDescription(shortDescription)
                .fillProductPriceFrom(fromPrice)
                .fillProductPriceTo(toPrice)
                .submit()
                .getVisibleProductCards()
                .stream().anyMatch(productCard -> assertName.equals(productCard.getName())));
    }


    @AfterEach
    public void finish() {
        advancedSearchPage.quit();
    }
}