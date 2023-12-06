package org.tacc.green1.model.pages.catalog;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.XPath;


public class ProductReviewsTab extends Component implements XPath.ProductReviewModal {
    @FindBy(id = "Rating_1_label")
    private WebElement ratingBar_star1;

    @FindBy(id = "Rating_2_label")
    private WebElement ratingBar_star2;

    @FindBy(id = "Rating_3_label")
    private WebElement ratingBar_star3;

    @FindBy(id = "Rating_4_label")
    private WebElement ratingBar_star4;

    @FindBy(id = "Rating_5_label")
    private WebElement ratingBar_star5;

    @FindBy(id = "nickname_field")
    private WebElement nickNameInput;

    @FindBy(id = "summary_field")
    private WebElement summaryInput;

    @FindBy(id = "review_field")
    private WebElement reviewInput;

    @FindBy(xpath = BUTTON_SUBMIT)
    private WebElement submitButton;

    @FindBy(css = "[data-ui-id=\"message-success\"]")
    private WebElement reviewSubmittedMessage;


    public ProductReviewsTab fillRatingBar(int rating) {
        switch (rating) {
            case 0 -> {} //To skip setting rating
            case 1 -> ratingBar_star1.click();
            case 2 -> ratingBar_star2.click();
            case 3 -> ratingBar_star3.click();
            case 4 -> ratingBar_star4.click();
            case 5 -> ratingBar_star5.click();
            default -> throw new IllegalArgumentException("Control your emotions, buddy!");
        }
        return this;
    }

    public ProductReviewsTab fillNickName(String nickname) {
        nickNameInput.sendKeys(nickname);
        return this;
    }

    public ProductReviewsTab fillSummary(String summary) {
        summaryInput.sendKeys(summary);
        return this;
    }

    public ProductReviewsTab fillReview(String review) {
        reviewInput.sendKeys(review);
        return this;
    }

    public ProductReviewsTab submit() {
        submitButton.click();
        return this;
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