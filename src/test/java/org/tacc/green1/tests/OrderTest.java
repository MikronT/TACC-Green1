package org.tacc.green1.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class OrderTest {
    @BeforeAll
    public static void prepare() {}


    @ParameterizedTest
    @CsvSource()
    public void test1() {}


    @AfterAll
    public static void finish() {}
}