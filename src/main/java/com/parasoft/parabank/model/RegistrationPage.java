package com.parasoft.parabank.model;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Page<RegistrationPage> {
    private static final String PAGE_URL = "register.htm";

    protected RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public String getLocalUrlPath () {
        return PAGE_URL;
    }


}
