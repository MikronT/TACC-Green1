package org.tacc.green1.util;

import org.openqa.selenium.interactions.Actions;


public class Actor {
    private static Actions actions;


    public static Actions getActions() {
        if (actions == null)
            actions = new Actions(DriverManager.getDriver());
        return actions;
    }
}