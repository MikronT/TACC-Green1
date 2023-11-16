package com.parasoft.parabank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends Page {
    private static final String PAGE_URL = "admin.htm";
    private static final By BUTTON_DB_INIT = By.cssSelector("[value=INIT]");
    private static final By BUTTON_DB_CLEAN = By.cssSelector("[value=CLEAN]");
    private static final By BUTTON_JMS_SHUTDOWN = By.cssSelector("[value=Shutdown]");
    private static final By BUTTON_JMS_STARTUP = By.cssSelector("[value=Startup]");
    private static final By LABEL_RESULT = By.xpath("//*[@id=rightPanel]/p/b");


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void initDatabase() {
        System.out.println("[Database] Initializing");
        driver.findElement(BUTTON_DB_INIT).click();
    }

    public void cleanDatabase() {
        System.out.println("[Database] Cleaning up");
        driver.findElement(BUTTON_DB_CLEAN).click();
    }

    public boolean isJMSServiceRunning() {
        //If there's no startup button, the service is running
        return driver.findElements(BUTTON_JMS_STARTUP).isEmpty();
    }

    public void shutdownJMSService() {
        System.out.println("[JMS Service] Shutting down");
        driver.findElement(BUTTON_JMS_SHUTDOWN).click();
    }

    public void startupJMSService() {
        System.out.println("[JMS Service] Starting up");
        driver.findElement(BUTTON_JMS_STARTUP).click();
    }


    public String getDatabaseControlRequestResult() {
        return driver.findElement(LABEL_RESULT).getText();
    }

    @Override
    protected String getLocalUrlPath() {
        return PAGE_URL;
    }
}