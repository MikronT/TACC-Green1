package org.tacc.green1.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.pages.Modal;

import java.util.List;

public class Cart extends Modal {
    @FindBy(css="body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a")
    private WebElement cartMenuToggle;

    @FindBy(id="top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(id="btn-minicart-close")
    private WebElement closeCartButton;

    @FindBy(id="mini-cart")
    private WebElement cartOrderList;


}