package org.tacc.green1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class RegistrationDataWriter {
    private static final Logger LOG = LogManager.getLogger(RegistrationDataWriter.class);
    private static final File FILE = new File("./src/test/resources/registrationData.csv");


    public static void clear() {
        boolean ignored = FILE.delete();
    }

    public static void append(String firstName, String lastName, String email, String password, String confirmPassword) {
        LOG.info("Writing new registration data entry to " + FILE);

        try (var writer = new FileWriter(FILE, true)) {
            writer.append(firstName).append(",")
                    .append(lastName).append(",")
                    .append(email).append(",")
                    .append(password).append(",")
                    .append(confirmPassword).append(System.lineSeparator());
        } catch (IOException e) {
            LOG.warn("Unable to save new registration data", e);
        }
    }
}