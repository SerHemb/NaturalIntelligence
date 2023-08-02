package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;


public class SignUpSteps {

    SignUpPage signUpPage = new SignUpPage();

    @When("enters signup information")
    public void userEntersSignupInformation() {
        signUpPage.enterInformation();
    }

    @And("submits the form")
    public void userSubmitsTheForm() {
        signUpPage.submit();
    }

    @Then("sees that confirmation email were sent")
    public void userSeesThatConfirmationEmailWereSent() {
        signUpPage.assertConfirmationMessage();
    }
}
