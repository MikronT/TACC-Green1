package org.tacc.green1.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GoodsItem {
    private final WebElement webElement;


    public GoodsItem(WebElement cartItem) {
        webElement = cartItem;
    }


    public void addItemToCart() {
        webElement.findElement(By.cssSelector("div > div > div.product-item-inner > div > div.actions-primary > form > button")).click();
    }

    public void chooseItemSize(int sizeCount) {
        WebElement sizeList = webElement.findElement(By.cssSelector("div.swatch-attribute.size > div"));
        WebElement chosenSize = sizeList.findElements(By.tagName("div")).get(sizeCount);
        chosenSize.click();
    }

    public void chooseItemColor(int sizeCount) {
        WebElement colorList = webElement.findElement(By.cssSelector("div.swatch-attribute.color > div"));
        WebElement chosenColor = colorList.findElements(By.tagName("div")).get(sizeCount);
        chosenColor.click();
    }
}