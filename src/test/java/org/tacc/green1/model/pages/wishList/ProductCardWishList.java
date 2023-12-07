package org.tacc.green1.model.pages.wishList;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.XPath;

public class ProductCardWishList extends Component implements XPath.ProductCardWishList {
    @FindBy(xpath = LABEL_NAME)
    private WebElement labelName;

    @FindBy(xpath = PRICE)
    private WebElement price;

    public ProductCardWishList(SearchContext context) {
        super(context);
    }

    public String getLabelName() {
        return labelName.getText();
    }

    public String getPrice() {
        return price.getText();
    }
}
