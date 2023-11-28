package org.tacc.green1.model.cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;
import org.tacc.green1.model.OrderPage;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.stream.Collectors;


public class Cart extends Modal<Cart> implements XPath.Cart {
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement openCart;

    @FindBy(xpath = CART_CLOSE)
    private WebElement closeCartButton;

    @FindBy(id = "mini-cart")
    private WebElement cartOrderList;

    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindAll({
            @FindBy(xpath = CART_ITEMS)
    })
    private List<WebElement> cartItems;


    public Cart open() {
        openCart.click();
        return this;
    }

    public List<CartItem> getCartItems() {
        return this.getVisibleCartItems();
    }

    public List<CartItem> getVisibleCartItems() {
        return cartItems.stream()
                .map(card -> PageFactory.initElements(card, CartItem.class))
                .collect(Collectors.toList());
    }

    public OrderPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return PageFactory.initElements(modalDriver, OrderPage.class);
    }
}