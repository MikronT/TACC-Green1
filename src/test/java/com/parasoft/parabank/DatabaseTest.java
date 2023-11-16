package com.parasoft.parabank;

import com.parasoft.parabank.model.AdminPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseTest {
    private static final WebDriver driver = new ChromeDriver();
    private static final AdminPage page = new AdminPage(driver);


    @BeforeEach
    public void openPage() {
        page.open();
    }

    @Test
    @Order(1)
    public void initDatabaseTest() {
        page.initDatabase();

        var actualResult = page.getDatabaseControlRequestResult();
        assertEquals("Database Initialized", actualResult);
    }

    @Test
    @Order(2)
    public void cleanDatabaseTest() {
        page.cleanDatabase();

        var actualResult = page.getDatabaseControlRequestResult();
        assertEquals("Database Cleaned", actualResult);
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}