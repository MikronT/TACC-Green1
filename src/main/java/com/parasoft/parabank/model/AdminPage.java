package com.parasoft.parabank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@SuppressWarnings("UnusedReturnValue")
public class AdminPage extends Page<AdminPage> {
    private static final String PAGE_URL = "admin.htm";
    private static final By BUTTON_DB_INIT = By.cssSelector("[value=\"INIT\"]");
    private static final By BUTTON_DB_CLEAN = By.cssSelector("[value=\"CLEAN\"]");
    private static final By BUTTON_JMS_SHUTDOWN = By.cssSelector("[value=\"Shutdown\"]");
    private static final By BUTTON_JMS_STARTUP = By.cssSelector("[value=\"Startup\"]");
    private static final By BUTTON_SUBMIT = By.xpath("//*[@id=\"adminForm\"]/input");
    private static final By LABEL_RESULT = By.xpath("//*[@id=\"rightPanel\"]/p/b");


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage initDatabase() {
        System.out.println("[Database] Initializing");
        driver.findElement(BUTTON_DB_INIT).click();
        return this;
    }

    public AdminPage cleanDatabase() {
        System.out.println("[Database] Cleaning up");
        driver.findElement(BUTTON_DB_CLEAN).click();
        return this;
    }

    public AdminPage shutdownJMSService() {
        System.out.println("[JMS Service] Shutting down");
        driver.findElement(BUTTON_JMS_SHUTDOWN).click();
        return this;
    }

    public AdminPage startupJMSService() {
        System.out.println("[JMS Service] Starting up");
        driver.findElement(BUTTON_JMS_STARTUP).click();
        return this;
    }

    public AdminPage setDataAccessMode(DataAccessMode mode) {
        driver.findElement(mode.getLocator()).click();
        return this;
    }

    public enum DataAccessMode {
        SOAP {
            @Override
            public By getLocator() {return By.id("accessMode1");}
        },
        REST_XML {
            @Override
            public By getLocator() {return By.id("accessMode2");}
        },
        REST_JSON {
            @Override
            public By getLocator() {return By.id("accessMode3");}
        },
        JDBC {
            @Override
            public By getLocator() {return By.id("accessMode4");}
        };

        public abstract By getLocator();
    }

    public AdminPage submit() {
        driver.findElement(BUTTON_SUBMIT).click();
        return this;
    }


    public String getResultLabelText() {
        return driver.findElement(LABEL_RESULT).getText();
    }

    public boolean isJMSServiceRunning() {
        //If there's no startup button, the service is running
        return driver.findElements(BUTTON_JMS_STARTUP).isEmpty();
    }

    public String getJMSServiceControlButtonText() {
        return driver.findElement(
                isJMSServiceRunning() ?
                        BUTTON_JMS_SHUTDOWN :
                        BUTTON_JMS_STARTUP
        ).getAttribute("value");
    }

    @Override
    protected String getLocalUrlPath() {
        return PAGE_URL;
    }
}