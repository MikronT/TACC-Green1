package org.tacc.green1.pages.catalog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.pages.Modal;
import org.tacc.green1.util.XPath;


public class ProductCard extends Modal<ProductCard> implements XPath.ProductCard {
    @FindBy(xpath = LABEL_NAME)
    private WebElement titleLabel;


    public String getName() {
        return titleLabel.getText();
    }
}