package org.tacc.green1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class DriverManager {
    private static final Logger LOG = LogManager.getLogger(DriverManager.class);

    private static Actions actions;
    private static WebDriver driver;


    private static WebDriver initDriver(String type) {
        LOG.info("Initializing driver: " + type);

        return switch (type) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> {
                String message = "Unexpected value: " + type;
                LOG.fatal(message);
                throw new IllegalArgumentException(message);
            }
        };
    }

    public static void setDriverType(String driverType) {
        driver = initDriver(driverType);
        actions = null;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            //Read driver type property
            String driverType = PropertiesReader.initLocal("driver.properties")
                    .getProperty("driver.type")
                    .toLowerCase();

            setDriverType(driverType);
        }
        return driver;
    }

    public static Actions getActions() {
        if (actions == null)
            actions = new Actions(driver);
        return actions;
    }


    public static void quitDriver() {
        if (driver == null)
            return;

        //Quit browser window
        driver.quit();
        //And null the driver to mark as ready to create
        driver = null;
    }
}