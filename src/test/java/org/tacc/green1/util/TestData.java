package org.tacc.green1.util;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {
    public interface RegisteredTestUser {
        String firstName = "John",
                lastName = "Doe",
                email = "teeest@eeeeeemail.com",
                password = "a@nMttMMD9dzDx9";

    }

    public interface NewTestUser {
        String firstName = "Nikola",
                lastName = "Tesla",
                email = "nikola.tesla10@gmail.com",
                password = "C>;\":decH9y|E/@m;3p~F94&vp",
                confirmPassword = "C>;\":decH9y|E/@m;3p~F94&vp";

        static Stream<Arguments> provideLoginValues() {
            return Stream.of(
                    Arguments.of(email, password)
            );
        }
    }
}