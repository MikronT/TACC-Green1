package org.example;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;


public class Util {
    private static final Random RANDOM = new Random();

    /**
     * Creates a random sequence of numbers in the XXX-XX-XXXX format
     *
     * @return string in the XXX-XX-XXXX format
     */
    private static String random324Number() {
        return randomNumeric(3) + "-" +
                randomNumeric(2) + "-" +
                randomNumeric(4);
    }

    public static String randomFederalTaxIdNumber() {
        return random324Number();
    }

    public static String randomSocialSecurityNumber() {
        return random324Number();
    }

    public static float randomHourlyRate() {
        return 0.01f * RANDOM.nextInt(5000, 10000);
    }

    public static int randomNumberOfHoursWorked() {
        return RANDOM.nextInt(40);
    }

    public static float randomMonthlyPayment() {
        return 0.01f * RANDOM.nextInt(1000 * 100, 10000 * 100);
    }
}