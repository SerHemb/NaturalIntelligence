package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.MainPage;

public class MainPageSteps {

    MainPage mainPage = new MainPage();


    @And("navigates to sign up page")
    public void navigatesToSignUpPage() {
        mainPage.navigateToSignUp();
    }

    @Given("an unauthorized user has landed on the {string} main page")
    public void anUnauthorizedUserHasLandedOnTheMainPage(String env) {
        if (env.equalsIgnoreCase("EasyChamp")) {
            mainPage.open();
        } else if (env.equalsIgnoreCase("EasyChampDev")) {
            mainPage.openDevURL();
        } else {
            mainPage.openURL(env);
        }
    }
}
