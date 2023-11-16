package com.parasoft.parabank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class AdminPage extends Page {
    private static final String PAGE_URL = "admin.htm";
    private static final By BUTTON_DB_INIT = By.cssSelector("[value=INIT]");
    private static final By BUTTON_DB_CLEAN = By.cssSelector("[value=CLEAN]");
    private static final By BUTTON_JMS_SHUTDOWN = By.cssSelector("[value=Shutdown]");
    private static final By BUTTON_JMS_RUN = By.cssSelector("[value=Startup]");
    private static final By LABEL_RESULT = By.xpath("//*[@id=\"rightPanel\"]/p/b");


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void initDatabase() {
        driver.findElement(BUTTON_DB_INIT).click();
    }

    public void cleanDatabase() {
        driver.findElement(BUTTON_DB_CLEAN).click();
    }

    public boolean isJMSServiceRunning() {
        try {
            driver.findElement(BUTTON_JMS_SHUTDOWN);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void shutdownJMSService() {
        driver.findElement(BUTTON_JMS_SHUTDOWN).click();
    }

    public void runJMSService() {
        driver.findElement(BUTTON_JMS_RUN).click();
    }


    public String getDatabaseControlRequestResult() {
        return driver.findElement(LABEL_RESULT).getText();
    }

    @Override
    protected String getLocalUrlPath() {
        return PAGE_URL;
    }
}