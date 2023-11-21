package com.parasoft.parabank.utils;

import org.openqa.selenium.WebDriver;


public abstract class Page<T extends Page<?>> {
    private static final String SITE_URL = "https://parabank.parasoft.com/parabank/";
    protected final WebDriver driver;


    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    public T open() {
        driver.get(getFullUrlAddress());
        //noinspection unchecked
        return (T) this;
    }


    public String getFullUrlAddress() {
        return SITE_URL + getLocalUrlPath();
    }

    protected abstract String getLocalUrlPath();
}