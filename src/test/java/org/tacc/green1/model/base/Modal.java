package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.tacc.green1.util.DriverManager;
import org.tacc.green1.util.PropertiesReader;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public abstract class Modal {
    private static final Logger LOG = LogManager.getLogger(Modal.class);

    protected WebDriver driver;
    private String COOKIE_SESSION_NAME;


    protected Modal() {
        driver = DriverManager.getDriver();
        var elementLocatorFactory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(elementLocatorFactory, this);

        if (COOKIE_SESSION_NAME == null) {
            COOKIE_SESSION_NAME = PropertiesReader
                    .initLocal("website.properties")
                    .getProperty("cookie.session");
        }
    }

    protected Modal(SearchContext context) {
        LOG.info("Initializing modal for class: " + getClass().getSimpleName());
        PageFactory.initElements(context, this);
    }


    public void timeoutByVisibility(WebElement... elements) {
        if (elements.length == 0) {
            LOG.debug("No elements to wait for");
            return;
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        LOG.debug("Waiting for elements: " + Arrays.toString(elements));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void timeoutByVisibility(int seconds, WebElement... elements) {
        if (elements.length == 0) {
            LOG.debug("No elements to wait for");
            return;
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        LOG.debug("Waiting for elements: " + Arrays.toString(elements));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    public void timeoutByVisibility(List<WebElement> elements) {
        timeoutByVisibility(elements.toArray(new WebElement[0]));
    }

    public void timeoutByInvisibility(int seconds, WebElement... elements) {
        if (elements.length == 0) {
            LOG.debug("No elements to wait for, returning...");
            return;
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        LOG.debug(String.format("Waiting for elements -> %s to disappear...", Arrays.stream(elements).toArray()));
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void timeoutByClickability(int seconds, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        LOG.debug("Waiting for clickable element: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isClientLoggedIn() {
        Cookie sessionID = driver.manage().getCookieNamed(COOKIE_SESSION_NAME);
        LOG.info(String.format("Cookie named %s value: %s", COOKIE_SESSION_NAME, sessionID));
        return sessionID != null;
    }
}