package com.parasoft.parabank.admin;

import com.parasoft.parabank.model.AdminPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTest {
    private static final WebDriver driver = new ChromeDriver();
    private static final AdminPage page = new AdminPage(driver);


    @BeforeEach
    public void openPage() {
        page.open();
    }


    @Test
    @Order(1)
    public void cleanDatabaseTest() {
        page.cleanDatabase();

        var actualResult = page.getDatabaseControlRequestResult();
        assertEquals("Database Cleaned", actualResult);
    }

    @Test
    @Order(2)
    public void initDatabaseTest() {
        page.initDatabase();

        var actualResult = page.getDatabaseControlRequestResult();
        assertEquals("Database Initialized", actualResult);
    }


    @AfterAll
    public static void quit() {
        driver.quit();
    }
}