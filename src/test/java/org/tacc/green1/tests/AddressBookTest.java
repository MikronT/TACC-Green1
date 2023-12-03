package org.tacc.green1.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.tacc.green1.model.account.AddressBookPage;
import org.tacc.green1.util.TestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AddressBookTest {
    private static final Logger LOG = LogManager.getLogger(AddressBookTest.class);
    private static AddressBookPage addressBookPage;


    @BeforeEach
    public void prepare() {
        var mainPage = TestClient.openBrowserAndRegister();

        addressBookPage = mainPage
                .openAccountPopup()
                .gotoMyAccountPage()
                .gotoAccountSidebar()
                .gotoAddressBookPage();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/addressList.csv")
    public void setNewUserShippingAddress(String firstName, String lastName, String company, String telephone,
                                          String street1, String street2, String street3, String city,
                                          String region, String zip, String country) {
        addressBookPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillCompany(company)
                .fillTelephone(telephone)
                .fillStreet1(street1)
                .fillStreet2(street2)
                .fillStreet3(street3)
                .fillCity(city)
                //Fill country first as the region select depends on the country chosen
                .selectCountry(country)
                .selectRegion(region)
                .fillZip(zip)
                .submit();

        var billingAddress = addressBookPage.getDefaultBillingAddress();
        var shippingAddress = addressBookPage.getDefaultShippingAddress();

        //Ensure neither is blank
        assertFalse(billingAddress.isBlank(), "Billing address is blank, probably timeout");
        //Then check for equality
        assertEquals(billingAddress, shippingAddress, "Billing and shipping addresses didn't match");

        LOG.info("Billing addresses matched");
    }


    @AfterEach
    public void finish() {
        TestClient.quitBrowser();
    }
}