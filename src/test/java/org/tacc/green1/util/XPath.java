package org.tacc.green1.util;

public interface XPath {
    interface MainPage {
        String LINK_WELCOME_ACCOUNT = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span",
                LINK_REGISTRATION = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a";
    }


    interface MainMenu {
        String MENU_ITEM_WOMEN = "//*[@id=\"store.menu\"]/nav/ul/li[2]",
                MENU_ITEM_WOMEN_LINK = MENU_ITEM_WOMEN + "/a",
                MENU_ITEM_WOMEN_TOPS = MENU_ITEM_WOMEN + "/ul/li[1]";
    }


    interface AccountPage {
        String CONTACT_INFORMATION_TEXT = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p";
    }


    interface AccountModal {
        String MY_ACCOUNT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a",
                MY_WISH_LIST_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a",
                SIGN_OUT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a";
    }


    interface AccountSidebar {
        String ACCOUNT_INFORMATION_LINK = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[7]/a";
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