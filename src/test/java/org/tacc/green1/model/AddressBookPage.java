package org.tacc.green1.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.tacc.green1.util.XPath;


public class AddressBookPage extends Modal<AddressBookPage> implements XPath.AddressBookPage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "telephone")
    private WebElement telephoneInput;

    @FindBy(id = "street_1")
    private WebElement streetInput1;

    @FindBy(id = "street_2")
    private WebElement streetInput2;

    @FindBy(id = "street_3")
    private WebElement streetInput3;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "region_id")
    private Select regionDropdown;

    @FindBy(id = "zip")
    private WebElement zipInput;

    @FindBy(id = "country")
    private Select countryDropdown;

    @FindBy(id = "")
    private WebElement submitButton;


    public AddressBookPage fillFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public AddressBookPage fillLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public AddressBookPage fillCompanyInput(String company) {
        companyInput.sendKeys(company);
        return this;
    }

    public AddressBookPage fillTelephoneInput(String telephone) {
        telephoneInput.sendKeys(telephone);
        return this;
    }

    public AddressBookPage fillStreetInput1(String street1) {
        streetInput1.sendKeys(street1);
        return this;
    }

    public AddressBookPage fillStreetInput2(String street2) {
        streetInput2.sendKeys(street2);
        return this;
    }

    public AddressBookPage fillStreetInput3(String street3) {
        streetInput3.sendKeys(street3);
        return this;
    }

    public AddressBookPage fillCityInput(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public AddressBookPage fillRegionDropdown(String region) {
        regionDropdown.selectByValue(region);
        return this;
    }

    public AddressBookPage fillZipInput(String zip) {
        zipInput.sendKeys(zip);
        return this;
    }

    public AddressBookPage fillCountryDropdown(String country) {
        countryDropdown.selectByValue(country);
        return this;
    }

    public AddressBookPage submit() {
        submitButton.click();
        return this;
    }
}