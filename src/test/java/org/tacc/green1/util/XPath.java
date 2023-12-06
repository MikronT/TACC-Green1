package org.tacc.green1.util;

@SuppressWarnings("SpellCheckingInspection")
public interface XPath {
    interface Header {
        String _HEADER = "/html/body/div[2]/header";
        String LINK_LOGO = _HEADER + "/div[2]/a";
        String LINK_WELCOME_ACCOUNT = _HEADER + "/div[1]/div/ul/li[1]/span";
        String LINK_REGISTRATION = _HEADER + "/div[1]/div/ul/li[3]/a";
        String BUTTON_OPEN_CART = _HEADER + "/div[2]/div[1]/a";

        interface HeaderMenu {

            String _OPTION = "//*[@id=\"store.menu\"]/nav/ul";

            String OPTION_WOMEN = _OPTION + "/li[2]";

            String OPTION_WOMEN_LINK = OPTION_WOMEN + "/a";
            String OPTIOM_WOMEN_MENU_ITEM = "//*[@id='ui-id-4']";

            String OPTION_WOMEN_ARROW = OPTION_WOMEN_LINK + "/span[1]";

            String OPTION_WOMEN_TOPS = OPTION_WOMEN + "/ul/li[1]";

            String OPTION_MEN = _OPTION + "/li[3]";

            String OPTION_MEN_LINK = OPTION_MEN + "/a";
            String OPTION_MEN_MENU_ITEM = "//*[@id='ui-id-5']";

            String OPTION_MEN_BOTTOMS = OPTION_MEN + "/ul/li[2]";

        }
    }

    interface Footer {
        String _FOOTER = "/html/body/div[2]/footer";
        String LINK_ADVANCED_SEARCH = _FOOTER + "/div/ul/li[3]/a";
    }

    interface AccountPage {
        String CONTACT_INFORMATION_TEXT = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p";
    }


    interface AccountPopup {
        String _OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul";
        String OPTION_MY_ACCOUNT = _OPTION + "/li[1]/a";
        String OPTION_MY_WISH_LIST = _OPTION + "/li[2]/a";
        String OPTION_SIGN_OUT = _OPTION + "/li[3]/a";
    }


    interface AccountSidebar {
        String _LINK = "//*[@id=\"block-collapsible-nav\"]/ul";
        String LINK_ADDRESS_BOOK = _LINK + "/li[6]/a";
        String LINK_ACCOUNT_INFORMATION = _LINK + "/li[7]/a";
    }


    interface AddressBookPage {
        String BUTTON_SUBMIT = "//*[@id=\"form-validate\"]/div/div[1]/button";
        String _ADDRESS_BLOCK = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]";
        String ADDRESS_BLOCK_BILLING = _ADDRESS_BLOCK + "/div[1]/div[1]/address";
        String ADDRESS_BLOCK_SHIPPING = _ADDRESS_BLOCK + "/div[2]/div[1]/address";
        String MESSAGE_ADDRESS_CHANGED = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div";
    }


    interface CatalogPage {
        String DROPDOWN_LIMITER = "//*[@class=\"toolbar toolbar-products\"][2]/div[@class=\"field limiter\"]/div/select";
        String FILTER_DROPDOWNS = "//*[@id=\"narrow-by-list\"]/div";
        String PRODUCT_CARDS = "//*[@class=\"products list items product-items\"]/li";
        String MESSAGE_ITEM_ADDED = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div";
    }


    interface FilterDropdown {
        String LABEL_NAME = "div[1]";
        String OPTIONS_LIST = "div[2]/ol/li/a";
        String OPTIONS_SQUARE = "div[2]/div/div/a/div";
    }


    interface ProductCard {
        String LABEL_NAME = "div/div/strong/a";
        String PRODUCT_PRICE = "div/div/div[1]/span/span/span[2]/span";
        String PRODUCT_COLOR = "div/div/div[2]/div[2]/div/div";
        String PRODUCT_SIZE = "div/div/div[2]/div[1]/div/div";
        String PRODUCT_ADD_BUTTON_CART = "div/div/div[3]/div/div[1]/form/button";
    }


    interface Cart {
        String BUTTON_CLOSE = "//*[@id=\"btn-minicart-close\"]";
        String ITEMS = "//*[@id=\"mini-cart\"]/li";
        String BUTTON_CHECKOUT = "//*[@id=\"top-cart-btn-checkout\"]";
        String ITEMS_COUNTER = "//span[@class='counter-label' and text()]";
        String MESSAGE_EMPTY_CART_OR_RECENTLY_ADDED = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong";
    }


    interface CartItem {
        String CART_ITEMS_WRAPPER = "//div[@data-action='scroll']";
        String CART_ITEMS_WRAPPER_CSS = "ol.minicart-items";
        String DELETE_BUTTON = "div/div/div[3]/div[2]/a";
        String BUTTON_CONFIRM_DELETE = "//button[@class='action-primary action-accept' and @type='button' and @data-role='action']/span[text()='OK']";
        String UPDATE_PRODUCT_BUTTON = "div/div/div[3]/div[1]/a";
        String QUANTITY_INPUT = "//*[@id=\"cart-item-487282-qty\"]";
        String SEE_DETAILS_BUTTON = "div/div/div[1]/span";
        String SIZE_TEXT = "div/div/div[1]/div/dl/dd[1]/span";
        String COLOR_TEXT = "div/div/div[1]/div/dl/dd[2]/span";
        String PRICE_TEXT = "div/div/div[2]/div[1]/span/span/span/span";
    }


    interface ProductReviewModal {
        String BUTTON_SUBMIT = "//*[@id=\"review-form\"]/div/div/button";
        String SUCCESS_ADDED_REVIEW_TEXT = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div";
    }


    interface OrderPage {
        String EMAIL = "//*[@id=\"customer-email\"]";

        String _FIELD = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div";
        String FIRST_NAME = _FIELD + "/div[1]/div/input";
        String LAST_NAME = _FIELD + "/div[2]/div/input";
        String COMPANY = _FIELD + "/div[3]/div/input";
        String STREET_ADDRESS = _FIELD + "/fieldset/div/div[1]/div/input";
        String CITY = _FIELD + "/div[4]/div/input";
        String STATE_PROVINCE = _FIELD + "/div[6]/div/input";
        String POSTAL_CODE = _FIELD + "/div[7]/div/input";
        String COUNTRY = _FIELD + "/div[8]/div/select/option[4]";
        String PHONE_NUMBER = _FIELD + "/div[9]/div/input";

        String SHIPPING_METHOD = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input";
        String NEXT_BUTTON = "//*[@id=\"shipping-method-buttons-container\"]/div/button";
        String PLACE_ORDER_BUTTON = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button";
        String THANKS_TEXT = "//*[@id=\"maincontent\"]/div[1]/h1/span";
        String BUTTON_CONTINUE_SHOPPING = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a";
        String LOADING_MASK = "//div[@class='loader']";
    }
}