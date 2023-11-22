package org.tacc.green1.model;

import org.openqa.selenium.WebDriver;


public abstract class Modal {
    protected final WebDriver driver;


    protected Modal(WebDriver driver) {
        this.driver = driver;
    }
}