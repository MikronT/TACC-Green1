package com.parasoft.parabank.model;

import org.openqa.selenium.WebDriver;


public abstract class Page {
    private static final String SITE_URL = "https://parabank.parasoft.com/parabank/";
    protected final WebDriver driver;


    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(getFullUrlAddress());
    }


    public String getFullUrlAddress() {
        return SITE_URL + getLocalUrlPath();
    }

    protected abstract String getLocalUrlPath();
}