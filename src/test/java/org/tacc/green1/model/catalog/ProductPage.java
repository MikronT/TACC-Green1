package org.tacc.green1.model.catalog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tacc.green1.model.Modal;


public class ProductPage extends Modal<ProductPage> {
    @FindBy(id = "tab-label-reviews")
    private WebElement reviewsTab;


    public ProductReviewsTab gotoProductReviewsTab() {
        reviewsTab.click();
        return PageFactory.initElements(modalDriver, ProductReviewsTab.class);
    }
}