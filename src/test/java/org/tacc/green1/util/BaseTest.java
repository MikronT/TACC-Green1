package org.tacc.green1.util;

import org.junit.jupiter.api.BeforeAll;
import org.tacc.green1.model.MainPage;


public class BaseTest {
    protected static MainPage mainPage;


    @BeforeAll
    public static void openMainPage() {
        mainPage = MainPage.openBrowser();
    }
}