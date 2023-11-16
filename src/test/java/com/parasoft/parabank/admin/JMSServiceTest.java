package com.parasoft.parabank.admin;

import com.parasoft.parabank.model.AdminPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JMSServiceTest {
    private static final WebDriver driver = new ChromeDriver();
    private static final AdminPage page = new AdminPage(driver);


    @BeforeAll
    public static void openPage() {
        page.open();

        boolean isServiceRunning = page.isJMSServiceRunning();
        System.out.println("JMS Service initial state: " + (isServiceRunning ? "RUNNING" : "STOPPED"));

        if (!isServiceRunning)
            page.startupJMSService();
    }


    @Test
    @Order(1)
    public void shutdownServiceTest() {
        page.shutdownJMSService();
    }

    @Test
    @Order(2)
    public void runServiceTest() {
        page.startupJMSService();
    }
}