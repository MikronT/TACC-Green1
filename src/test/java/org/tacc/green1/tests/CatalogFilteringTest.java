package org.tacc.green1.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.catalog.CatalogPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CatalogFilteringTest {
    private static final Logger LOG = LogManager.getLogger(CatalogFilteringTest.class);
    private static CatalogPage catalogPage;


    @BeforeEach
    public void prepare() {
        catalogPage = MainPage.initPage().open()
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
        catalogPage.quit();
    }
}