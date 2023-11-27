package org.tacc.green1.util;

public interface XPath {
    interface MainPage {
        String LINK_WELCOME_ACCOUNT = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span",
                LINK_REGISTRATION = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a",
                LINK_ADVANCED_SEARCH = "/html/body/div[2]/footer/div/ul/li[3]/a";
    }


    interface MainMenu {
        String _OPTION = "//*[@id=\"store.menu\"]/nav/ul",
                OPTION_WOMEN = _OPTION + "/li[2]",
                OPTION_WOMEN_LINK = OPTION_WOMEN + "/a",
                OPTION_WOMEN_TOPS = OPTION_WOMEN + "/ul/li[1]",
                OPTION_MEN = _OPTION + "/li[3]",
                OPTION_MEN_LINK = OPTION_MEN + "/a",
                OPTION_MEN_BOTTOMS = OPTION_MEN + "/ul/li[2]";
    }


    interface AccountPage {
        String CONTACT_INFORMATION_TEXT = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p";
    }


    interface AccountPopup {
        String _OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul",
                OPTION_MY_ACCOUNT = _OPTION + "/li[1]/a",
                OPTION_MY_WISH_LIST = _OPTION + "/li[2]/a",
                OPTION_SIGN_OUT = _OPTION + "/li[3]/a";
    }


    interface AccountSidebar {
        String _LINK = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul",
                LINK_ADDRESS_BOOK = _LINK + "/li[6]/a",
                LINK_ACCOUNT_INFORMATION = _LINK + "/li[7]/a";
    }


    interface AddressBookPage {
        String BUTTON_SUBMIT = "//*[@id=\"form-validate\"]/div/div[1]/button";
    }


    interface CatalogPage {
        String DROPDOWN_LIMITER = "//*[@class=\"toolbar toolbar-products\"][2]/div[3]/div/select",
                FILTER_DROPDOWNS = "//*[@id=\"narrow-by-list\"]/div",
                PRODUCT_CARDS = "//*[@class=\"products list items product-items\"]/li";
    }


    interface FilterDropdown {
        String LABEL_NAME = "div[1]";
        String OPTIONS_LIST = "div[2]/ol/li/a";
        String OPTIONS_SQUARE = "div[2]/div/div/a/div";
    }


    interface ProductCard {
        String LABEL_NAME = "div/div/strong/a";
    }


    interface ProductReviewModal {
        String BUTTON_SUBMIT = "//*[@id=\"review-form\"]/div/div/button";
    }
}