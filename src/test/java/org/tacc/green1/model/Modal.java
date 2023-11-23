package org.tacc.green1.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


public abstract class Modal {
    protected static WebDriver modalDriver;
    private static final Logger LOG = LogManager.getLogger(Modal.class);

    protected Modal(WebDriver driver) {
        modalDriver = driver;
    }

    protected static RemoteWebDriver initialize(String browserName) {
        String message = "No such driver! Options are: chrome, firefox, edge, safari";
        return switch (browserName) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> {
                LOG.error(message);
                throw new RuntimeException(message);
            }
        };
    }

     protected abstract void quit();
}