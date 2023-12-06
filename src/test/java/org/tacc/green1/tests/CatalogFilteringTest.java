package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CatalogFilteringTest extends BaseTest {
    private static Page<?> page;
    private static CatalogPage catalogPage;


    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @BeforeEach
    public void prepare() {
        catalogPage = page
                .gotoHeaderComponent()
                .gotoHeaderMenu()
                .openWomenCategoryPopup()
                .gotoWomenTopsCatalogPage()
                .showMaxProductsPerPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/catalogFilters.csv")
    public void loginTest(String filterName,
                          String filterArgument,
                          String exampleProduct) {
        catalogPage.applyFilter(filterName, filterArgument);

        boolean exampleProductFound = catalogPage
                .getVisibleProductCards()
                .stream()
                .anyMatch(productCard -> exampleProduct.equals(productCard.getName()));

        assertTrue(exampleProductFound, "Applied filters didn't return the example product");
    }
}