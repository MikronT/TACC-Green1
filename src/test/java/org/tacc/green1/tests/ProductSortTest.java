package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.model.pages.catalog.ProductCard;
import org.tacc.green1.model.pages.catalog.ProductReviewsTab;
import org.tacc.green1.util.TestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSortTest extends BaseTest {
    private static Page page;
    private static CatalogPage catalogPage;

    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();

        catalogPage = page
                .gotoHeaderComponent()
                .gotoHeaderMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();
    }

    @Test
    public void productSortTest() {
        List<ProductCard> sortedProductCards = catalogPage.getVisibleProductCards().stream().sorted(productCart -> productCart.);

        //assertEquals();
    }

}
