package org.tacc.green1.model.cart;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Modal;
import org.tacc.green1.util.XPath;


public class CartItem extends Modal<CartItem> implements XPath.CartItem {
    @FindBy(xpath = DELETE_BUTTON)
    private WebElement deleteButton;

    @FindBy(xpath = QUANTITY_INPUT)
    private WebElement quantityInput;

    @FindBy(xpath = UPDATE_PRODUCT_BUTTON)
    private WebElement updateProductButton;

    @FindBy(xpath = SEE_DETAILS_BUTTON)
    private WebElement seeDetailsButton;

    @FindBy(xpath = SIZE_TEXT)
    private WebElement sizeText;

    @FindBy(xpath = COLOR_TEXT)
    private WebElement colorText;

    @FindBy(xpath = PRICE_TEXT)
    private WebElement priceText;

    @FindBy(xpath = CONFIRM_DELETE_BUTTON)
    private WebElement confirmDeleteButton;


    public CartItem(SearchContext context) {
        super(context);
    }


    public CartItem setQuantity(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity + "");
        return this;
    }

    public CartItem toggleSeeDetails() {
        seeDetailsButton.click();
        return this;
    }

    public CartItem updateProduct() {
        updateProductButton.click();
        return this;
    }

    public CartItem deleteItemFromCart() {
        deleteButton.click();

        timeoutByVisibility(confirmDeleteButton);
        return this;
    }

    public CartItem confirmDelete() {
        confirmDeleteButton.click();

        timeout(1);
        return this;
    }


    public String getQuantity() {
        return quantityInput.getText();
    }

    public String getSize() {
        return sizeText.getText();
    }

    public String getColor() {
        return colorText.getText();
    }

    public String getPrice() {
        return priceText.getText();
    }
}