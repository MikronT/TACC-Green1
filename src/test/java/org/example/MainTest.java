package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainTest {
    @Test
    public void test() {
        var driver = new ChromeDriver();
        driver.get("https://uk.wikipedia.org");
        driver.quit();
    }
}