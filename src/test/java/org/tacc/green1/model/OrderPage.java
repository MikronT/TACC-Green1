package org.tacc.green1.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class OrderPage extends Modal<OrderPage> {
    @FindBy(css = "#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol")
    private WebElement goodsListElement;

    private final List<WebElement> goodsList = goodsListElement.findElements(By.tagName("li"));
}