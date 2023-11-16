package com.parasoft.parabank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class PropertiesInitializer {
    private PropertiesInitializer() {}

    public static Properties initialize(String propertyPath) {
        Properties returnProps = new Properties();

        try (FileInputStream stream = new FileInputStream(propertyPath)) {
            returnProps.load(stream);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return returnProps;
    }

    public static String getPath(String fileName) {
        return ClassLoader.getSystemResource(fileName).getPath();
    }
}