package org.tacc.green1.model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.base.Page;


public class MainPage extends Page {
    private static final Logger LOG = LogManager.getLogger(MainPage.class);


    public static MainPage open(String url) {
        var mainPage = new MainPage();

        LOG.info("Opening main page by URL: " + url);
        mainPage.driver.get(url);

        return mainPage;
    }
}