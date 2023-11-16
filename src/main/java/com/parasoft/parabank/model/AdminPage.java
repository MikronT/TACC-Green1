package com.parasoft.parabank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends Page {
    private static final String PAGE_URL = "admin.htm";
    private static final By BUTTON_INIT = By.cssSelector("[value=INIT]");
    private static final By BUTTON_CLEAN = By.cssSelector("[value=CLEAN]");
    private static final By LABEL_RESULT = By.xpath("//*[@id=\"rightPanel\"]/p/b");


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void initDatabase() {
        driver.findElement(BUTTON_INIT).click();
    }

    public void cleanDatabase() {
        driver.findElement(BUTTON_CLEAN).click();
    }


    public String getDatabaseControlRequestResult() {
        return driver.findElement(LABEL_RESULT).getText();
    }

    @Override
    protected String getLocalUrlPath() {
        return PAGE_URL;
    }
}