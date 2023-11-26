package org.tacc.green1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tacc.green1.util.Utils;

import java.time.Duration;


public abstract class Modal<T> {
    private static Actions modalActions = null;
    private static WebDriverWait modalWait;
    protected static WebDriver modalDriver;


    protected static WebDriverWait modalWait() {
        if (modalWait == null)
            modalWait = new WebDriverWait(modalDriver, Duration.ofSeconds(3));
        return modalWait;
    }

    protected static Actions modalActions() {
        if (modalActions == null)
            modalActions = new Actions(modalDriver);
        return modalActions;
    }

    public void quit() {
        modalDriver.quit();
    }


    @SuppressWarnings("unchecked")
    public T timeout(int seconds) {
        Utils.sleep(seconds);
        return (T) this;
    }
}