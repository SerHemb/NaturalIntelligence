package pages;

import static tools.CommonTools.getByObject;

public class MainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://easychamp.com/";
    private static final String MAIN_PAGE_URL_DEV = "https://dev.easychamp.com/";
    public String MENU_TOAST = "css=.ModalMenuContainer_burger__IS_VP";
    public String SIGN_UP_BUTTON = "xpath=//button[contains(.,'Sign Up')]";

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void openDevURL() {
        driver.get(MAIN_PAGE_URL_DEV);
    }

    public void navigateToSignUp() {
        wait.forElementToBeDisplayed(20, getByObject(MENU_TOAST), "MENU_TOAST");
        driver.findElement(getByObject(MENU_TOAST)).click();
        driver.findElement(getByObject(SIGN_UP_BUTTON)).click();
    }

    public void openURL(String env) {
        driver.get(env);
    }
}
