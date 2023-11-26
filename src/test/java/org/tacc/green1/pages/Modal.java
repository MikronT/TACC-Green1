package org.tacc.green1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.tacc.green1.util.Utils;


public abstract class Modal<T> {
    private static Actions modalActions = null;
    protected static WebDriver modalDriver;


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