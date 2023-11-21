package org.tacc.green1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class SampleTest {
    @Test
    public void test() {
        var driver = new ChromeDriver();
        driver.get("https://uk.wikipedia.org");
        driver.quit();
    }
}