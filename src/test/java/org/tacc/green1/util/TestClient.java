package org.tacc.green1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.MainPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;


public class TestClient {
    private static final Logger LOG = LogManager.getLogger(TestClient.class);
    private static final Path FILE = new File("./src/test/resources/registrationData.csv").toPath();

    private static String firstName = "Nikola";
    private static String lastName = "Tesla";
    private static String email = "nikola14.tesla10@gmail.com";
    private static String password = "C>;:decH9y|E/@m;3p~F94&vp";


    public static void pickAnySavedUser() {
        var random = new Random();

        String line = "";
        try (var lines = Files.lines(FILE)) {
            line = lines.filter(s -> random.nextBoolean())
                    .findAny()
                    .orElse("");
        } catch (IOException e) {
            LOG.warn("Unable to read file, returning empty data", e);
        }

        var client = new TestClient();

        String[] words = line.split(",");
        if (words.length < 4)
            return;

        setFirstName(words[0]);
        setLastName(words[1]);
        setEmail(words[2]);
        setPassword(words[3]);
    }

    public static void setFirstName(String value) {
        firstName = value;
    }

    public static void setLastName(String value) {
        lastName = value;
    }

    public static void setEmail(String value) {
        email = value;
    }

    public static void setPassword(String value) {
        password = value;
    }


    public static void save() {
        var line = firstName + "," + lastName + "," + email + "," + password + System.lineSeparator();

        LOG.info("Saving user: " + line);

        try {
            Files.write(FILE, line.getBytes(),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            LOG.warn("Unable to save new registration data", e);
        }
    }

    public static void deleteAll() {
        try {
            Files.delete(FILE);
        } catch (IOException e) {
            LOG.error("Unable to delete registration data file", e);
        }
    }


    public static MainPage openBrowser() {
        String url = PropertiesReader.initLocal("website.properties")
                .getProperty("url");

        //Open browser window
        var driver = DriverManager.getDriver();

        LOG.info("Opening main page by URL: " + url);
        driver.get(url);

        return new MainPage();
    }

    public static MainPage openBrowserAndLogin() {
        pickAnySavedUser();

        LOG.info("Logging in as " + firstName + ' ' + lastName + " with " + email);

        return openBrowser()
                .gotoLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .submit();
    }

    public static MainPage openBrowserAndRegister() {
        var firstName = RandomData.name();
        var lastName = RandomData.name();
        var email = RandomData.email();
        var password = RandomData.password();

        LOG.info("Registering as " + firstName + ' ' + lastName + " with " + email);

        return openBrowser()
                .gotoRegistrationPage()

                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .fillPassword(password)
                .fillConfirmPassword(password)
                .submit()

                .gotoMainPage();
    }

    public static void quitBrowser() {
        DriverManager.quitDriver();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}