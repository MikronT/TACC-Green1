package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.components.FooterComponent;
import org.tacc.green1.model.base.components.HeaderComponent;
import org.tacc.green1.util.XPath;


public abstract class Page<T> extends Modal implements XPath.Page {
    private static final Logger LOG = LogManager.getLogger(Page.class);

    @FindBy(xpath = BUTTON_CONFIRM_DELETE)
    private WebElement confirmDeleteButton;

    @SuppressWarnings("unchecked")
    public T confirmDelete() {
        timeoutByVisibility(confirmDeleteButton);

        confirmDeleteButton.click();

        timeout(3);
        return (T) this;
    }

    public FooterComponent gotoFooterComponent() {
        LOG.debug(String.format("Moving into %s", FooterComponent.class));
        return new FooterComponent();
    }

    public HeaderComponent gotoHeaderComponent() {
        LOG.debug(String.format("Moving into %s", HeaderComponent.class));
        return new HeaderComponent();
    }
}