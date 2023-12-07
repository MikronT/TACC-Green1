package org.tacc.green1.model.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.components.FooterComponent;
import org.tacc.green1.model.components.header.HeaderComponent;
import org.tacc.green1.util.XPath;


public abstract class Page extends Modal implements XPath.Page {
    private static final Logger LOG = LogManager.getLogger(Page.class);

    @FindBy(xpath = HEADER)
    private WebElement headerBlock;

    @FindBy(xpath = FOOTER)
    private WebElement footerBlock;


    public HeaderComponent gotoHeaderComponent() {
        LOG.debug(String.format("Moving into class %s", HeaderComponent.class.getSimpleName()));
        return new HeaderComponent(headerBlock);
    }

    public FooterComponent gotoFooterComponent() {
        LOG.debug(String.format("Moving into class %s", FooterComponent.class.getSimpleName()));
        return new FooterComponent(footerBlock);
    }
}