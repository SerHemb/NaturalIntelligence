package pages;

import static tools.CommonTools.sleep;

public class SignInPage extends BasePage {
    String url = "https://dev.easychamp.com/";
    String SIGN_IN_BUTTON = "xpath=//button[normalize-space()='Sign In']";
    String LOGIN_INPUT = "xpath=//*[@id='EmailOrUsername']";
    String PASSWORD_INPUT = "xpath=//*[@id='Password']";
    String SUBMIT_BUTTON = "xpath=//*[@id='submit-btn']";

    public void userLoggedInAs(String login, String password) {

        driver.get(url);
        steps.clickTo(SIGN_IN_BUTTON);
        steps.typeIn(login, LOGIN_INPUT);
        steps.typeIn(password, PASSWORD_INPUT);
        steps.sendKeyTo("ENTER", SUBMIT_BUTTON);
        sleep(3000);
    }
}

