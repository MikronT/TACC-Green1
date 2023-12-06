package org.tacc.green1.model.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.tacc.green1.model.base.Page;
import org.tacc.green1.util.XPath;


public class AddressBookPage extends Page<AddressBookPage> implements XPath.AddressBookPage {
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
    private WebElement regionDropdown;

    @FindBy(id = "zip")
    private WebElement zipInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(xpath = BUTTON_SUBMIT)
    private WebElement submitButton;

    @FindBy(xpath = MESSAGE_ADDRESS_CHANGED)
    private WebElement addressChangedMessage;

    @FindBy(xpath = ADDRESS_BLOCK_BILLING)
    private WebElement billingAddressBlock;

    @FindBy(xpath = ADDRESS_BLOCK_SHIPPING)
    private WebElement shippingAddressBlock;


    public AddressBookPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public AddressBookPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public AddressBookPage fillCompany(String company) {
        companyInput.sendKeys(company);
        return this;
    }

    public AddressBookPage fillTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
        return this;
    }

    public AddressBookPage fillStreet1(String street1) {
        streetInput1.sendKeys(street1);
        return this;
    }

    public AddressBookPage fillStreet2(String street2) {
        streetInput2.sendKeys(street2);
        return this;
    }

    public AddressBookPage fillStreet3(String street3) {
        streetInput3.sendKeys(street3);
        return this;
    }

    public AddressBookPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public AddressBookPage selectRegion(String region) {
        var regionSelect = new Select(regionDropdown);
        regionSelect.selectByVisibleText(region);
        return this;
    }

    public AddressBookPage fillZip(String zip) {
        zipInput.sendKeys(zip);
        return this;
    }

    public AddressBookPage selectCountry(String country) {
        var countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);
        return this;
    }

    public AddressBookPage submit() {
        submitButton.click();

        timeoutByVisibility(addressChangedMessage);
        return this;
    }


    public String getDefaultBillingAddress() {
        return billingAddressBlock.getText();
    }

    public String getDefaultShippingAddress() {
        return shippingAddressBlock.getText();
    }
}