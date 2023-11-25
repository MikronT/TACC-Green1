package org.tacc.green1.pages;

import org.openqa.selenium.WebDriver;
import org.tacc.green1.util.Utils;


public abstract class Modal<T> {
    protected static WebDriver modalDriver;


    public void quit() {
        modalDriver.quit();
    }

    public <T extends Modal> T redirect(Class<T> pageClass) {
        return PageFactory.initElements(modalDriver, pageClass);
    }

    @SuppressWarnings("unchecked")
    public T timeout(int seconds) {
        Utils.sleep(seconds);
        return (T) this;
    }
}