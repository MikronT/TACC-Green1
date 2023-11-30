package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.tacc.green1.util.DriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;


public abstract class Modal<T> {
    private static final Logger LOG = LogManager.getLogger(Modal.class);


    protected Modal() {
        this(DriverManager.getDriver());
    }

    protected Modal(SearchContext context) {
        LOG.info("Initializing modal for class: " + getClass().getSimpleName());
        PageFactory.initElements(context, this);
    }


    //TODO 28.11.2023: Get rid of this piece of garbage
    @SuppressWarnings("unchecked")
    public T timeoutByLocator(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return (T) this;
    }

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