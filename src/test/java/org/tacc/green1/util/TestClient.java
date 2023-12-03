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

    private String firstName = "Nikola";
    private String lastName = "Tesla";
    private String email = "nikola14.tesla10@gmail.com";
    private String password = "C>;:decH9y|E/@m;3p~F94&vp";


    public static TestClient pickAnySavedUser() {
        var random = new Random();

        String line = "";
        try (var lines = Files.lines(FILE)) {
            line = lines.filter(s -> random.nextBoolean())
                    .findAny()
                    .orElse("");
        } catch (IOException e) {
            LOG.warn("Unable to read file, returning empty data", e);
        }

        var testClient = new TestClient();

        String[] words = line.split(",");
        if (words.length < 4)
            return testClient;

        return testClient
                .setFirstName(words[0])
                .setLastName(words[1])
                .setEmail(words[2])
                .setPassword(words[3]);
    }

    public TestClient setFirstName(String value) {
        firstName = value;
        return this;
    }

    public TestClient setLastName(String value) {
        lastName = value;
        return this;
    }

    public TestClient setEmail(String value) {
        email = value;
        return this;
    }

    public TestClient setPassword(String value) {
        password = value;
        return this;
    }


    public void save() {
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

        return new MainPage().open(url);
    }

    public static MainPage openBrowserAndLogin(TestClient testClient) {
        LOG.info("Logging in as "
                + testClient.getFirstName() + ' '
                + testClient.getLastName() + " with "
                + testClient.getEmail());

        return openBrowser()
                .gotoLoginPage()
                .fillEmail(testClient.getEmail())
                .fillPassword(testClient.getPassword())
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}