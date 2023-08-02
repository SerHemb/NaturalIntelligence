package steps;

import io.cucumber.java.en.And;
import pages.ConfirmationFormPage;

public class ConfirmationFormSteps {

    ConfirmationFormPage confirmationFormPage = new ConfirmationFormPage();

    @And("fills out confirmation form")
    public void fillsOutConfirmationForm() {
        confirmationFormPage.filloutForm();
    }
}
