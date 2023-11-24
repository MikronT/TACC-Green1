package org.tacc.green1.pages.components;

import org.openqa.selenium.WebElement;

public class CartItem {
    private WebElement webElement;

    public CartItem(WebElement cartItem) {
        webElement = cartItem;
    }

    void deleteItemFromCart() {}
    void updateItemInCart() {}
    void updateNumberOfItems() {}
    void toggleSeeDetails() {}
    void getOrderSize() {}
    void getOrderColor() {}
    //WebElement getWebElement() {}
    void setWebElement(WebElement newCartItem) {
        webElement = newCartItem;
    }
}
