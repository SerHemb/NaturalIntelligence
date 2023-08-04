package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;

public class SignInSteps {

    SignInPage signInPage = new SignInPage();

    @Given("user logs in as {string} {string}")
    public void userLoggedInAs(String login, String password) {
        signInPage.userLoggedInAs(login, password);
    }
}
