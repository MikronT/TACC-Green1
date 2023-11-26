package org.tacc.green1.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CartItem {
    private WebElement webElement;


    public CartItem(WebElement cartItem) {
        webElement = cartItem;
    }


    void deleteItemFromCart() {
        webElement.findElement(By.cssSelector("div > div > div.product.actions > div.secondary > a")).click();
    }

    //void updateItemInCart() {}
    void setQuantity(int quantity) {
        WebElement input = webElement.findElement(By.tagName("input"));
        input.sendKeys(quantity + "");
    }

    void toggleSeeDetails() {
        webElement.findElement(By.cssSelector("div > div > div.product.options.active > span")).click();
    }

    String getOrderSize() {
        return webElement.findElement(By.cssSelector("div > div > div.product.options.active > div > dl > dd:nth-child(2) > span")).getText();
    }

    String getOrderColor() {
        return webElement.findElement(By.cssSelector("div > div > div.product.options.active > div > dl > dd:nth-child(4) > span")).getText();
    }

    WebElement getWebElement() {
        return webElement;
    }

    void setWebElement(WebElement newCartItem) {
        webElement = newCartItem;
    }
}