package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.catalog.CatalogPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CatalogFilteringTest {
    private static CatalogPage catalogPage;


    @BeforeEach
    public void prepare() {
        catalogPage = MainPage.openBrowser()
                .gotoMainMenu()
                .openWomenCategoryPopup()
                .gotoWomenTopsCatalogPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/catalogFilters.csv")
    public void loginTest(String filterName,
                          String filterArgument,
                          String mandatoryResult) {
        assertTrue(catalogPage
                .showMaxProductsPerPage()
                .applyFilter(filterName, filterArgument)
                .getVisibleProductCards()
                .stream()
                .anyMatch(productCard -> mandatoryResult.equals(productCard.getName())));
    }


    @AfterEach
    public void finish() {
        catalogPage.quitDriver();
    }
}