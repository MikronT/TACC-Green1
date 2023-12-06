package org.tacc.green1.model.pages.catalog;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.XPath;

import java.util.List;

import static java.lang.Double.parseDouble;


public class ProductCard extends Component implements XPath.ProductCard {
    @FindBy(xpath = LABEL_NAME)
    private WebElement titleLabel;

    @FindBy(xpath = PRODUCT_PRICE)
    private WebElement price;

    @FindAll({
            @FindBy(xpath = PRODUCT_SIZE)
    })
    private List<WebElement> sizeList;

    @FindAll({
            @FindBy(xpath = PRODUCT_COLOR)
    })
    private List<WebElement> colorList;

    @FindBy(xpath = PRODUCT_ADD_BUTTON_CART)
    private WebElement productAddButtonCart;

    public ProductCard(SearchContext context) {
        super(context);
    }


    public ProductPage gotoProductPage() {
        titleLabel.click();
        return new ProductPage();
    }

    public ProductCard chooseColor(String color) {
        colorList.stream()
                .filter(item -> color.equals(item.getAttribute("aria-label")))
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }

    public ProductCard chooseSize(int size) {
        sizeList.stream()
                .filter(item -> {
                    int itemSize = Integer.parseInt(item.getAttribute("aria-label"));
                    return size == itemSize;
                })
                .findFirst()
                .ifPresent(WebElement::click);

        return this;
    }

    public <T> T  submitAddToCart() {
        productAddButtonCart.click();
        return (T) this;
    }


    public String getName() {
        return titleLabel.getText();
    }

    public Double getPrice() { return parseDouble(price.getText().substring(1)); };
}