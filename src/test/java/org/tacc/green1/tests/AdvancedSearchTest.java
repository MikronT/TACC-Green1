package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.model.search.AdvancedSearchPage;


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
                               String toPrice) {
        //TODO 27.11.2023: Finish advanced search
        var catalogAdvancedSearchPage = advancedSearchPage
                .fillProductName(productName)
                .submit();
    }


    @AfterEach
    public void finish() {
        advancedSearchPage.quit();
    }
}