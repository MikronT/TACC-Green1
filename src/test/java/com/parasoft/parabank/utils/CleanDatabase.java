package com.parasoft.parabank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CleanDatabase {
    public static void cleanDB(WebDriver driver) {
        WebElement adminPanel = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[6]/a"));
        adminPanel.click();

        WebElement cleanButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/table/tbody/tr/td[1]/form/table/tbody/tr/td[2]/button"));
        cleanButton.click();
    }

}
