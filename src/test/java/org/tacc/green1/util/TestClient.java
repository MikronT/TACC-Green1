package org.tacc.green1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.LoginPage;
import org.tacc.green1.model.pages.MainPage;
import org.tacc.green1.model.pages.RegistrationPage;

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


    public static TestClient generateRandomNewClient() {
        return new TestClient()
                .setFirstName(RandomData.name())
                .setLastName(RandomData.name())
                .setEmail(RandomData.email())
                .setPassword(RandomData.password());
    }

    public static TestClient pickAnySavedKnownClient() {
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

        return MainPage.open(url);
    }

    public void login(Page<?> page) {
        LOG.info("Logging in as "
                + getFirstName() + ' '
                + getLastName() + " with "
                + getEmail());

        var loginPage = page instanceof LoginPage castToLoginPage ?
                castToLoginPage :
                page.gotoHeaderComponent().gotoLoginPage();

        loginPage
                .fillEmail(getEmail())
                .fillPassword(getPassword())
                .submit();
    }

    public void register(Page<?> page) {
        LOG.info("Registering as "
                + getFirstName() + ' '
                + getLastName() + " with "
                + getEmail());

        var registrationPage = page instanceof RegistrationPage castToRegistrationPage ?
                castToRegistrationPage :
                page.gotoHeaderComponent().gotoRegistrationPage();

        registrationPage
                .fillFirstName(getFirstName())
                .fillLastName(getLastName())
                .fillEmail(getEmail())
                .fillPassword(getPassword())
                .fillConfirmPassword(getPassword())
                .submit()

                .gotoHeaderComponent()
                .gotoMainPage();
    }

    public static void quitBrowser() {
        DriverManager.quitDriver();
    }
}