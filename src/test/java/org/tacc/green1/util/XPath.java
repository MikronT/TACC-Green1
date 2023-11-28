package org.tacc.green1.util;

public interface XPath {
    interface MainPage {
        String LINK_WELCOME_ACCOUNT = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span", LINK_REGISTRATION = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a", LINK_ADVANCED_SEARCH = "/html/body/div[2]/footer/div/ul/li[3]/a";
    }


    interface MainMenu {
        String _OPTION = "//*[@id=\"store.menu\"]/nav/ul", OPTION_WOMEN = _OPTION + "/li[2]", OPTION_WOMEN_LINK = OPTION_WOMEN + "/a", OPTION_WOMEN_TOPS = OPTION_WOMEN + "/ul/li[1]", OPTION_MEN = _OPTION + "/li[3]", OPTION_MEN_LINK = OPTION_MEN + "/a", OPTION_MEN_BOTTOMS = OPTION_MEN + "/ul/li[2]";
    }


    interface AccountPage {
        String CONTACT_INFORMATION_TEXT = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p";
    }


    interface AccountPopup {
        String _OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul", OPTION_MY_ACCOUNT = _OPTION + "/li[1]/a", OPTION_MY_WISH_LIST = _OPTION + "/li[2]/a", OPTION_SIGN_OUT = _OPTION + "/li[3]/a";
    }


    interface AccountSidebar {
        String _LINK = "//*[@id=\"block-collapsible-nav\"]/ul", LINK_ADDRESS_BOOK = _LINK + "/li[6]/a", LINK_ACCOUNT_INFORMATION = _LINK + "/li[7]/a";
    }


    interface AddressBookPage {
        String BUTTON_SUBMIT = "//*[@id=\"form-validate\"]/div/div[1]/button", _ADDRESS_BLOCK = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]", ADDRESS_BLOCK_BILLING = _ADDRESS_BLOCK + "/div[1]/div[1]/address", ADDRESS_BLOCK_SHIPPING = _ADDRESS_BLOCK + "/div[2]/div[1]/address";
    }


    interface CatalogPage {
        String DROPDOWN_LIMITER = "//*[@class=\"toolbar toolbar-products\"][2]/div[3]/div/select", FILTER_DROPDOWNS = "//*[@id=\"narrow-by-list\"]/div", PRODUCT_CARDS = "//*[@class=\"products list items product-items\"]/li";
    }


    interface FilterDropdown {
        String LABEL_NAME = "div[1]";
        String OPTIONS_LIST = "div[2]/ol/li/a";
        String OPTIONS_SQUARE = "div[2]/div/div/a/div";
    }


    interface ProductCard {
        String LABEL_NAME = "div/div/strong/a",
                PRODUCT_COLOR = "div/div/div[2]/div[2]/div/div",
                PRODUCT_SIZE = "div/div/div[2]/div[1]/div/div",
                PRODUCT_ADD_BUTTON_CART = "div/div/div[3]/div/div[1]/form/button";
    }


    interface Cart {
        String CART_OPEN = "/html/body/div[2]/header/div[2]/div[1]/a", CART_CLOSE = "//*[@id=\"btn-minicart-close\"]", CART_ITEMS = "//*[@id=\"mini-cart\"]/li";
    }


    interface CartItem {

        String DELETE_BUTTON = "div/div/div[3]/div[2]/a",
                UPDATE_PRODUCT_BUTTON = "div/div/div[3]/div[1]/a",
                QUANTITY_INPUT = "//*[@id=\"cart-item-487282-qty\"]",
                SEE_DETAILS_BUTTON = "div/div/div[1]/span",
                SIZE_TEXT = "div/div/div[1]/div/dl/dd[1]/span",
                COLOR_TEXT = "div/div/div[1]/div/dl/dd[2]/span",
                PRICE_TEXT = "div/div/div[2]/div[1]/span/span/span/span",
                CONFIRM_DELETE_BUTTON = "//button[@class='action-primary action-accept' and @type='button' and @data-role='action']/span[text()='OK']";
    }


    interface ProductReviewModal {
        String BUTTON_SUBMIT = "//*[@id=\"review-form\"]/div/div/button";
    }

    interface OrderPage {
        String EMAIL = "//*[@id=\"customer-email\"]",
                FIRST_NAME = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input",
                LAST_NAME = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input",
                COMPANY = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[3]/div/input",
                STREET_ADDRESS = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input",
                CITY = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input",
                STATE_PROVINCE = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[6]/div/input",
                POSTAL_CODE = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input",
                COUNTRY = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select/option[4]",
                PHONE_NUMBER = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input",
                SHIPPING_METHOD = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input",
                NEXT_BUTTON = "//*[@id=\"shipping-method-buttons-container\"]/div/button",
                PLACE_ORDER_BUTTON = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button",
                THANKS_TEXT = "//*[@id=\"maincontent\"]/div[1]/h1/span";
    }
}