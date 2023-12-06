package org.tacc.green1.model.pages.catalog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;


public class ProductPage extends Page<ProductPage> {
    @FindBy(id = "tab-label-reviews")
    private WebElement reviewsTab;


    public ProductReviewsTab gotoProductReviewsTab() {
        reviewsTab.click();
        return new ProductReviewsTab();
    }
}