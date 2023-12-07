package org.tacc.green1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.TestClient;

public class MyWishListTest extends BaseTest{
    private static Page page;
    private static

    @BeforeAll
    public static void initClient() {
        page = TestClient.openBrowser();
    }

    @ParameterizedTest
    @CsvSource()
    public void myWishList () {

    }
}
