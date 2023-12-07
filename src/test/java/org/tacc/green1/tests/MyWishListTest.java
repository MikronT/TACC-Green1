package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.MainPage;
import org.tacc.green1.model.pages.catalog.CatalogPage;
import org.tacc.green1.model.pages.catalog.ProductCard;
import org.tacc.green1.model.pages.wishList.MyWishListPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyWishListTest extends BaseTest{
    private static Page page;
    private static MainPage mainPage;
    private static MyWishListPage myWishListPage;

    private static CatalogPage catalogPage;

    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @ParameterizedTest
    @CsvSource("volodymyr.nakonechnyi@gmail.com, Fw35tgvAXypdEgfX6YuyUW")
    public void myWishList (String email, String password) {
        mainPage = page.gotoHeaderComponent()
                .gotoLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .submit();

        catalogPage = mainPage.gotoHeaderComponent()
                .gotoHeaderMenu()
                .openMenCategoryPopup()
                .gotoMenBottomsCatalogPage();

        ProductCard productCard = catalogPage
                .getVisibleProductCards()
                .get(0);

        String labelName = productCard
                .getName();

        myWishListPage = productCard
                .addProductCardToWishList();

        String labelNameWishList = myWishListPage
                .getVisibleWishListItems()
                .get(0)
                .getLabelName();

        assertEquals(labelName, labelNameWishList);
    }
}
