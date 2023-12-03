package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.tacc.green1.util.TestClient;


public class BaseTest {
    @AfterAll
    public static void quitBrowserAfterAll() {
        TestClient.quitBrowser();
    }
}