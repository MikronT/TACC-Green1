package org.tacc.green1.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.TestClient;


public class LoginPage extends Page<LoginPage> {
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(css = "button.action.login.primary")
    private WebElement submitButton;


    public LoginPage fillEmail(String email) {
        emailInput.sendKeys(email);
        TestClient.setEmail(email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        TestClient.setPassword(password);
        return this;
    }

    public MainPage submit() {
        submitButton.click();
        return new MainPage();
    }
}