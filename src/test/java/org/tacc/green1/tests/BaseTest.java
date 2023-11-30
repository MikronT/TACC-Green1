package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.tacc.green1.model.MainPage;
import org.tacc.green1.util.TestClient;


public class BaseTest {
    protected static MainPage mainPage;


    @BeforeAll
    public static void openMainPage() {
        mainPage = TestClient.openBrowser();
    }


    @AfterAll
    public static void finish() {
        TestClient.quitBrowser();
    }
}