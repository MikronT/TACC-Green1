package com.parasoft.parabank.utils;

public class XPath {
    public interface RegisterPage {
        String submitButton = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input",
                successRegisterText = "/html/body/div[1]/div[3]/div[2]/p";

    }


    public interface Login {
        String loginButton = "/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input",
                usernameInput = "/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input",
                passwordInput = "/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input",
                successLogin = "/html/body/div[1]/div[3]/div[1]/h2";

    }

    public interface Logout {
        String logoutButton = "/html/body/div[1]/div[3]/div[1]/ul/li[8]/a";

    }

    public interface UpdatePage {
        String updateInfoButton = "/html/body/div[1]/div[3]/div[1]/ul/li[6]/a",
                updateButton = "/html/body/div[1]/div[3]/div[2]/div/div/form/table/tbody/tr[8]/td[2]/input",
                updateForm = "/html/body/div[1]/div[3]/div[2]/div/div/form/table",
                profileUpdated = "/html/body/div[1]/div[3]/div[2]/div/div/h1",
                welcomeText = "/html/body/div[1]/div[3]/div[1]/p";
    }
}
