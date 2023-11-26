package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.pages.MainPage;
import org.tacc.green1.pages.search.AdvancedSearchPage;

public class AdvancedSearchTest {
    private AdvancedSearchPage advancedSearchPage;

    @BeforeEach
    public void openAdvancedSearchPage() {
        advancedSearchPage = MainPage.initPage().open().gotoAdvancedSearchPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/advancedSearchData.csv")
    public void advancedSearch(String productName,
                               String sku,
                               String description,
                               String shortDescription,
                               String fromPrice,
                               String toPrice) {

        advancedSearchPage.fillProductName(productName == null ? "" : productName)
                .submit();
        //.fillEmail(email)
        //.fillPassword(password)
        //.submit()
        //.timeout(3)
        //..redirect(MainPage.class)
        // .isLoggedIn();
    }

    @AfterEach
    public void finish() {
        advancedSearchPage.quit();
    }

}
