package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.components.FooterComponent;
import org.tacc.green1.model.components.header.HeaderComponent;


public abstract class Page extends Modal {
    private static final Logger LOG = LogManager.getLogger(Page.class);

    public FooterComponent gotoFooterComponent() {
        LOG.debug(String.format("Moving into %s", FooterComponent.class));
        return new FooterComponent();
    }

    public HeaderComponent gotoHeaderComponent() {
        LOG.debug(String.format("Moving into %s", HeaderComponent.class));
        return new HeaderComponent();
    }
}