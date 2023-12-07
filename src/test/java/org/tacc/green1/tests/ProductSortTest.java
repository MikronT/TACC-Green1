package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.model.pages.catalog.ProductCard;
import org.tacc.green1.model.pages.catalog.ProductReviewsTab;
import org.tacc.green1.util.TestClient;

import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Double> sortedProductCards = catalogPage
                                .getVisibleProductCards()
                                .stream()
                                .sorted(Comparator.comparingDouble(ProductCard::getPrice))
                                .map(ProductCard::getPrice)
                                .collect(Collectors.toList());



        catalogPage
                .getSortDropdown()
                .sortDropdownClick()
                .chooseOption("Price");

        List<Double> currentProductCarts = catalogPage
                                            .getVisibleProductCards()
                                            .stream()
                                            .map(ProductCard::getPrice)
                                            .collect(Collectors.toList());

        assertEquals(sortedProductCards,
                currentProductCarts);
    }

}

