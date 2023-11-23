package org.tacc.green1.util;

public class XPath {
    public interface Registration {
        String INPUT_FIRST_NAME = "//*[@id=\"firstname\"]",
                INPUT_LAST_NAME = "//*[@id=\"lastname\"]",
                INPUT_EMAIL = "//*[@id=\"email_address\"]",
                INPUT_PASSWORD = "//*[@id=\"password\"]",
                INPUT_CONFIRM_PASSWORD = "//*[@id=\"password-confirmation\"]",
                INPUT_SUBMIT_BUTTON = "//*[@id=\"form-validate\"]/div/div[1]/button";
    }

    public interface AccountSelect {
        String ACCOUNT_SELECT_BUTTON = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button",
                MY_ACCOUNT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a",
                MY_WISH_LIST_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a",
                SIGN_OUT_OPTION = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a";
    }

    public interface AccountProfile {
        String MY_ACCOUNT_WELCOME_TEXT = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1";
    }

    public interface MainPage {
        String WELCOME_MESSAGE_MAIN_PAGE = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span",
                LINK_REGISTRATION = "[class=\"header links\"]/li[3]";
    }
}
