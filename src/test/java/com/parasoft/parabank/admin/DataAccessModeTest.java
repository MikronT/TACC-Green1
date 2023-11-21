package com.parasoft.parabank.admin;

import com.parasoft.parabank.utils.pages.AdminPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataAccessModeTest {
    private static final WebDriver driver = new ChromeDriver();
    private static final AdminPage page = new AdminPage(driver);


    @BeforeAll
    public static void openPage() {
        page.open();

        page.setDataAccessMode(AdminPage.DataAccessMode.JDBC).submit();
    }


    @Test
    @Order(1)
    public void chooseDataAccessMode_SOAP() {
        chooseDataAccessMode(AdminPage.DataAccessMode.SOAP);
    }

    @Test
    @Order(2)
    public void chooseDataAccessMode_REST_XML() {
        chooseDataAccessMode(AdminPage.DataAccessMode.REST_XML);
    }

    @Test
    @Order(3)
    public void chooseDataAccessMode_REST_JSON() {
        chooseDataAccessMode(AdminPage.DataAccessMode.REST_JSON);
    }

    @Test
    @Order(4)
    public void chooseDataAccessMode_JDBC() {
        chooseDataAccessMode(AdminPage.DataAccessMode.JDBC);
    }

    private void chooseDataAccessMode(AdminPage.DataAccessMode mode) {
        page.setDataAccessMode(mode).submit();

        var actualResult = page.getResultLabelText();
        assertEquals("Settings saved successfully.", actualResult);
    }


    @AfterAll
    public static void quit() {
        driver.quit();
    }
}