package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.function.Function;


public abstract class Modal {
    private static final Logger LOG = LogManager.getLogger(Modal.class);

    private String COOKIE_SESSION_NAME;
    protected final WebDriver driver;


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


    private <V> void timeout(int seconds, Function<WebDriver, V> expectedConditionFunction) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(expectedConditionFunction);
    }

    protected void timeoutByVisibility(int seconds, WebElement... elements) {
        LOG.debug("Waiting for elements to appear: " + Arrays.toString(elements));

        timeout(seconds,
                localDriver -> ExpectedConditions
                        .visibilityOfAllElements(elements)
                        .apply(localDriver));
    }

    protected void timeoutByVisibility(WebElement... elements) {
        timeoutByVisibility(7, elements);
    }

    protected void timeoutByVisibility(List<WebElement> elements) {
        timeoutByVisibility(elements.toArray(new WebElement[0]));
    }

    protected void timeoutByInvisibility(int seconds, WebElement... elements) {
        LOG.debug("Waiting for elements to disappear: " + Arrays.toString(elements));

        timeout(seconds,
                localDriver -> ExpectedConditions
                        .invisibilityOfAllElements(elements)
                        .apply(localDriver));
    }

    protected void timeoutByClickability(int seconds, WebElement element) {
        LOG.debug("Waiting for element to be clickable: " + element);

        timeout(seconds,
                localDriver -> ExpectedConditions
                        .elementToBeClickable(element)
                        .apply(localDriver));
    }


    public boolean isClientLoggedIn() {
        Cookie sessionID = driver.manage().getCookieNamed(COOKIE_SESSION_NAME);
        LOG.info(String.format("Cookie named %s value: %s", COOKIE_SESSION_NAME, sessionID));
        return sessionID != null;
    }
}