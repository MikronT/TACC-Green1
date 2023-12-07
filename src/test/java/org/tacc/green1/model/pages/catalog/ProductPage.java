package org.tacc.green1.model.pages.catalog;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;


public class ProductPage extends Page {
    @FindBy(id = "tab-label-reviews")
    private WebElement reviewsTab;

    @FindBy(id = "reviews")
    private WebElement reviewsTabBlock;

    @FindBy(css = "[data-ui-id=\"message-success\"]")
    private WebElement reviewSubmittedMessage;


    public ProductReviewsTab gotoProductReviewsTab() {
        reviewsTab.click();
        return new ProductReviewsTab(reviewsTabBlock);
    }


    public boolean isReviewSubmitted() {
        try {
            timeoutByVisibility(reviewSubmittedMessage);
        } catch (TimeoutException ignored) {
            //Element is not found, no success message
            return false;
        }

        var message = reviewSubmittedMessage.getText();
        //Manual success message check
        return message.contains("You submitted ");
    }
}