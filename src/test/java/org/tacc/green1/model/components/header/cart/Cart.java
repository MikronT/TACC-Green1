package org.tacc.green1.model.components.header.cart;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.model.pages.OrderPage;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.stream.Collectors;


public class Cart extends Component implements XPath.Cart {
    @FindBy(xpath = BUTTON_CLOSE)
    private WebElement closeButton;

    @FindBy(xpath = MESSAGE_EMPTY_CART_OR_RECENTLY_ADDED)
    private WebElement emptyCartOrRecentlyAddedMessage;

    @FindAll({
            @FindBy(xpath = ITEMS)
    })
    private List<WebElement> cartItems;

    @FindBy(xpath = BUTTON_CHECKOUT)
    private WebElement checkoutButton;


    public Cart(SearchContext context) {
        super(context);
    }


    public List<CartItem> getVisibleCartItems() {
        return cartItems.stream()
                .map(CartItem::new)
                .collect(Collectors.toList());
    }

    public OrderPage proceedToCheckout() {
        timeoutByInvisibility(5, emptyCartOrRecentlyAddedMessage);
        timeoutByVisibility(5, checkoutButton);

        checkoutButton.click();
        return new OrderPage();
    }
}