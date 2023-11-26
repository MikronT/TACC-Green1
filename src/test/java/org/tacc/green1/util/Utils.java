package org.tacc.green1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Utils {
    private static final Logger LOG = LogManager.getLogger(Utils.class);

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver initDriver() {
        LOG.info("started driver initialization...");
        String driverType = PropertiesInitializer.initializeLocalProperties("driver.properties").getProperty("driver.type");
        return switch (driverType) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> {
                LOG.fatal("Unexpected value: " + driverType);
                throw new IllegalStateException("Unexpected value: " + driverType);
            }
        };
    }
}