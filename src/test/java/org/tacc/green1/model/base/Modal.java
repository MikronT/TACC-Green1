package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.tacc.green1.util.DriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public abstract class Modal<T> {
    private static final Logger LOG = LogManager.getLogger(Modal.class);


    protected Modal() {
        var driver = DriverManager.getDriver();
        var elementLocatorFactory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(elementLocatorFactory, this);
    }

    protected Modal(SearchContext context) {
        LOG.info("Initializing modal for class: " + getClass().getSimpleName());
        PageFactory.initElements(context, this);
    }


    //TODO 01.12.2023: Get rid of generic T return value
    public T timeoutByVisibility(WebElement... elements) {
        return timeoutByVisibility(Arrays.stream(elements).toList());
    }

    @SuppressWarnings("unchecked")
    public T timeoutByVisibility(List<WebElement> elements) {
        if (elements.isEmpty()) {
            LOG.debug("No elements to wait for");
            return (T) this;
        }

        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

        LOG.debug("Waiting for elements: " + elements);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return (T) this;
    }

    //TODO 28.11.2023: Get rid of this piece of garbage
    @Deprecated
    @SuppressWarnings({"unchecked", "DeprecatedIsStillUsed"})
    public T timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return (T) this;
    }
}