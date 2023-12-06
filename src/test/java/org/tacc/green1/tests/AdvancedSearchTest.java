package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.AdvancedSearchPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdvancedSearchTest extends BaseTest {
    private static Page<?> page;
    private AdvancedSearchPage advancedSearchPage;


    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @BeforeEach
    public void gotoAdvancedSearchPage() {
        advancedSearchPage = page.gotoFooterComponent().gotoAdvancedSearchPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/advancedSearchData.csv")
    public void searchProducts(String productName,
                               String sku,
                               String description,
                               String shortDescription,
                               String fromPrice,
                               String toPrice,
                               String assertName) {
        var catalogPage = advancedSearchPage
                .fillProductName(productName)
                .fillProductSKU(sku)
                .fillProductDescription(description)
                .fillProductShortDescription(shortDescription)
                .fillProductPriceFrom(fromPrice)
                .fillProductPriceTo(toPrice)
                .submit();

        boolean exampleProductFound = catalogPage
                .getVisibleProductCards()
                .stream()
                .anyMatch(productCard -> assertName.equals(productCard.getName()));

        assertTrue(exampleProductFound, "Applied search criteria didn't return the example product");
    }
}