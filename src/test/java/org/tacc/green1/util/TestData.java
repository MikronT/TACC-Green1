package org.tacc.green1.util;

public class TestData {
    public interface RegisteredTestUser {
        String firstName = "John",
                lastName = "Doe",
                email = "teeest@eeeeeemail.com",
                password = "a@nMttMMD9dzDx9";
    }

    public static class NewTestUser {
        private static final String
                firstName = "Nikola",
                lastName = "Tesla",
                email = "nikola.tesla10@gmail.com",
                password = "C>;\":decH9y|E/@m;3p~F94&vp",
                confirmPassword = "C>;\":decH9y|E/@m;3p~F94&vp";

        public static String getCSVNewUser() {
            return firstName + "," + lastName + "," + email + "," + password + "," + confirmPassword;
        }
    }
}