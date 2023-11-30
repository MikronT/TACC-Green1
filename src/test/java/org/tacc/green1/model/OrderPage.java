package org.tacc.green1.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.XPath;


public class OrderPage extends Page<OrderPage> implements XPath.OrderPage {
    @FindBy(xpath = EMAIL)
    private WebElement email;

    @FindBy(xpath = FIRST_NAME)
    private WebElement firstName;

    @FindBy(xpath = LAST_NAME)
    private WebElement lastName;

    @FindBy(xpath = COMPANY)
    private WebElement company;

    @FindBy(xpath = STREET_ADDRESS)
    private WebElement streetAddress;

    @FindBy(xpath = CITY)
    private WebElement city;

    @FindBy(xpath = STATE_PROVINCE)
    private WebElement stateProvince;

    @FindBy(xpath = POSTAL_CODE)
    private WebElement postalCode;

    @FindBy(xpath = COUNTRY)
    private WebElement country;

    @FindBy(xpath = PHONE_NUMBER)
    private WebElement phoneNumber;

    @FindBy(xpath = SHIPPING_METHOD)
    private WebElement shippingMethod;

    @FindBy(xpath = NEXT_BUTTON)
    private WebElement nextButton;

    @FindBy(xpath = PLACE_ORDER_BUTTON)
    private WebElement placeOrderButton;

    @FindBy(xpath = THANKS_TEXT)
    private WebElement thanksText;


    public OrderPage enterEmail(String emailAddress) {
        email.sendKeys(emailAddress);
        return this;
    }

    public OrderPage enterFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    public OrderPage enterLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
        return this;
    }

    public OrderPage enterCompany(String companyValue) {
        company.sendKeys(companyValue);
        return this;
    }

    public OrderPage enterStreetAddress(String streetAddressValue) {
        streetAddress.sendKeys(streetAddressValue);
        return this;
    }

    public OrderPage enterCity(String cityValue) {
        city.sendKeys(cityValue);
        return this;
    }

    public OrderPage enterStateProvince(String stateProvinceValue) {
        stateProvince.sendKeys(stateProvinceValue);
        return this;
    }

    public OrderPage enterPostalCode(String postalCodeValue) {
        postalCode.sendKeys(postalCodeValue);
        return this;
    }

    public OrderPage selectCountry(String countryValue) {
        //TODO 29.11.2023: Pick specified country
        country.click();
        return this;
    }

    public OrderPage enterPhoneNumber(String phoneNumberValue) {
        phoneNumber.sendKeys(phoneNumberValue);
        return this;
    }

    public OrderPage fillForm(String email, String firstName, String lastName,
                              String company, String streetAddress, String city, String country, String postalCode,
                              String stateProvince, String phoneNumber) {
        return enterEmail(email)
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterCompany(company)
                .enterStreetAddress(streetAddress)
                .enterCity(city)
                .selectCountry(country)
                .enterPostalCode(postalCode)
                .enterStateProvince(stateProvince)
                .enterPhoneNumber(phoneNumber);
    }

    public OrderPage selectShippingMethod() {
        shippingMethod.click();
        return this;
    }

    public OrderPage nextPage() {
        nextButton.click();
        return this;
    }

    public OrderPage placeOrder() {
        placeOrderButton.click();
        return this;
    }


    public String getThanksText() {
        return thanksText.getText();
    }
}