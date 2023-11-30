package org.tacc.green1.model.cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.OrderPage;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.stream.Collectors;


public class Cart extends Modal<Cart> implements XPath.Cart {
    @FindBy(xpath = BUTTON_CLOSE)
    private WebElement closeButton;

    @FindBy(id = "mini-cart")
    private WebElement orderList;

    @FindAll({
            @FindBy(xpath = ITEMS)
    })
    private List<WebElement> cartItems;

    @FindBy(xpath = BUTTON_CHECKOUT)
    private WebElement proceedToCheckoutButton;


    public List<CartItem> getVisibleCartItems() {
        return cartItems.stream()
                .map(CartItem::new)
                .collect(Collectors.toList());
    }

    public OrderPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return new OrderPage();
    }
}