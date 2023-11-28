package org.tacc.green1.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.DriverManager;
import org.tacc.green1.util.PropertiesReader;


public class MainPage extends Page<MainPage> {
    private static final Logger LOG = LogManager.getLogger(MainPage.class);


    public static MainPage openBrowser() {
        String url = PropertiesReader.initLocal("website.properties")
                .getProperty("url");

        LOG.info("Opening main page by URL: " + url);
        //Open browser window
        DriverManager.getDriver().get(url);

        return new MainPage();
    }
}