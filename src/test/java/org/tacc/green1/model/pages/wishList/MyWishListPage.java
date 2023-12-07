package org.tacc.green1.model.pages.wishList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.util.XPath;

import java.util.List;

public class MyWishListPage implements XPath.MyWishList {
    @FindBy(xpath = WISH_LIST)
    private WebElement wishList;

    @FindAll(
            @FindBy(xpath = WISH_LIST_ITEM)
    )
    private List<WebElement> wishListItems;

    public List<WebElement> getVisibleWishListItems() {
        return wishListItems;
    }
}
