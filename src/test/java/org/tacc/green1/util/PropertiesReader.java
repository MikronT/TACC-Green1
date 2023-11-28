package org.tacc.green1.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class PropertiesReader {
    public static Properties init(String propertiesPath) {
        Properties returnProps = new Properties();

        try (FileInputStream stream = new FileInputStream(propertiesPath)) {
            returnProps.load(stream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        return returnProps;
    }

    public static Properties initLocal(String filename) {
        return init(getLocalPath(filename));
    }

    private static String getLocalPath(String filename) {
        return ClassLoader.getSystemResource(filename).getPath();
    }
}