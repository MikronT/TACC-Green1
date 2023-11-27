package org.tacc.green1.util;

import static org.apache.commons.lang3.RandomStringUtils.*;


public class RandomData {
    public static String name() {
        return randomAlphanumeric(5, 10).toLowerCase();
    }

    public static String email() {
        return String.format("%s@%s.%s",
                        randomAlphanumeric(5, 10),
                        randomAlphanumeric(5, 10),
                        randomAlphabetic(2, 3))
                .toLowerCase();
    }

    public static String password() {
        return randomAscii(8, 16);
    }
}