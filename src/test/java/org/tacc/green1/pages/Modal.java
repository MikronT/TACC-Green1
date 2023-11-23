package org.tacc.green1.pages;

import org.openqa.selenium.WebDriver;

public abstract class Modal {
    protected static WebDriver modalDriver;

    public Modal() {
    }

    public void quit() {
        modalDriver.quit();
    }
}