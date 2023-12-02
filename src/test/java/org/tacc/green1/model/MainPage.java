package org.tacc.green1.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.base.Page;


public class MainPage extends Page<MainPage> {
    private static final Logger LOG = LogManager.getLogger(MainPage.class);


    public MainPage open(String url) {
        LOG.info("Opening main page by URL: " + url);
        driver.get(url);
        return this;
    }
}