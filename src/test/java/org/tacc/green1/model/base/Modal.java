package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.util.DriverManager;


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
    public T timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return (T) this;
    }
}