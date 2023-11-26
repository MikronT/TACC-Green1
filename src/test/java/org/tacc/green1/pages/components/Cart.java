package org.tacc.green1.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.pages.Modal;

import java.util.List;


public class Cart extends Modal<Cart> {
    @FindBy(css = "body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a")
    private WebElement cartMenuToggle;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "btn-minicart-close")
    private WebElement closeCartButton;

    @FindBy(id = "mini-cart")
    private WebElement cartOrderList;


    private CartItem getCartItemSafely(List<WebElement> cartItems, int itemCount) {
        try {
            return new CartItem(cartItems.get(itemCount));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item count: " + itemCount);
            return null;
        }
    }

    public void deleteItemFromCart(int itemCount) {
        List<WebElement> cartItems = cartOrderList.findElements(By.tagName("li"));
        CartItem cartItem = getCartItemSafely(cartItems, itemCount);

        if (cartItem != null) {
            cartItem.deleteItemFromCart();
        }
    }

    public void setItemQuantity(int itemCount, int newQuantity) {
        List<WebElement> cartItems = cartOrderList.findElements(By.tagName("li"));
        CartItem cartItem = getCartItemSafely(cartItems, itemCount);

        if (cartItem != null) {
            cartItem.setQuantity(newQuantity);
        }
    }

    public String getItemColor(int itemCount) {
        List<WebElement> cartItems = cartOrderList.findElements(By.tagName("li"));
        CartItem cartItem = getCartItemSafely(cartItems, itemCount);

        return (cartItem != null) ? cartItem.getOrderColor() : null;
    }

    public String getItemSize(int itemCount) {
        List<WebElement> cartItems = cartOrderList.findElements(By.tagName("li"));
        CartItem cartItem = getCartItemSafely(cartItems, itemCount);

        return (cartItem != null) ? cartItem.getOrderSize() : null;
    }
}