package org.tacc.green1.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class PropertiesInitializer {
    public static Properties initializeLocalProperties(String filename) {
        return initialize(getLocalPath(filename));
    }

    public static Properties initialize(String propertiesPath) {
        Properties returnProps = new Properties();

        try (FileInputStream stream = new FileInputStream(propertiesPath)) {
            returnProps.load(stream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        return returnProps;
    }

    public static String getLocalPath(String filename) {
        return ClassLoader.getSystemResource(filename).getPath();
    }
}