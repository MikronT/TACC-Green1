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


    interface ProductReviewModal {
        String BUTTON_SUBMIT = "//*[@id=\"review-form\"]/div/div/button";
    }
}