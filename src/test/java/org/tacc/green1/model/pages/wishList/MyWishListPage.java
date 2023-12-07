package org.tacc.green1.model.pages.wishList;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.model.pages.wishList.ProductCardWishList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.util.XPath;

import java.util.List;
import java.util.stream.Collectors;

public class MyWishListPage extends Page implements XPath.MyWishList {
    @FindBy(xpath = WISH_LIST)
    private WebElement wishList;

    @FindAll(
            @FindBy(xpath = WISH_LIST_ITEM)
    )
    private List<WebElement> wishListItems;

    public List<ProductCardWishList> getVisibleWishListItems() {
        return wishListItems.stream()
                .map(ProductCardWishList::new)
                .collect(Collectors.toList());
    }
}
