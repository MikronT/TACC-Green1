package org.tacc.green1.util;

public class XPath {
    public interface AccountSelect {
        String MY_ACCOUNT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a",
                MY_WISH_LIST_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a",
                SIGN_OUT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a";
    }

    public interface MainPage {
        String WELCOME_MESSAGE_MAIN_PAGE = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span",
                LINK_REGISTRATION = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a";
    }
}
