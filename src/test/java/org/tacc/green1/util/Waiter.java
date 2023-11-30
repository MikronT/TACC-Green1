package org.tacc.green1.util;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waiter {
    private static WebDriverWait wait;


    public static WebDriverWait get3SecondWait() {
        if (wait == null)
            wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(3));
        return wait;
    }
}