package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

public abstract class Component extends Modal {
    private static final Logger LOG = LogManager.getLogger(Component.class);
    protected Component(SearchContext context) {
        LOG.info("Initializing modal for class: " + getClass().getSimpleName());
        PageFactory.initElements(context, this);
    }

    protected Component() {}
}