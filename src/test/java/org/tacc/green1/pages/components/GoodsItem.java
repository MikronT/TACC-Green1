package org.tacc.green1.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoodsItem {
    private WebElement webElement;

    public GoodsItem(WebElement cartItem) {
        webElement = cartItem;
    }

    public void addItemToCart() {
        webElement.findElement(By.cssSelector("div > div > div.product-item-inner > div > div.actions-primary > form > button")).click();
    }

    public void chooseItemSize(int sizeCount) {
        WebElement sizeList = webElement.findElement(By.cssSelector("div.swatch-attribute.size > div"));
        WebElement choosenSize = sizeList.findElements(By.tagName("div")).get(sizeCount);
        choosenSize.click();
    }

    public void chooseItemColor(int sizeCount) {
        WebElement colorList = webElement.findElement(By.cssSelector("div.swatch-attribute.color > div"));
        WebElement chosenColor = colorList.findElements(By.tagName("div")).get(sizeCount);
        chosenColor.click();
    }
}
