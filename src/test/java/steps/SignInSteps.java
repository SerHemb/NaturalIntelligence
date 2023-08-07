package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import tools.APIRequests;

public class SignInSteps {
    SignInPage signInPage = new SignInPage();
    APIRequests apiRequests = new APIRequests();

    @Given("user logs in as {string} {string}")
    public void userLoggedInAs(String login, String password) {
        signInPage.userLoggedInAs(login, password);
    }

    /**
     * API requests
     * @param login
     * @param password
     */
    @Given("user logs in as {string} {string} and saveAuthorization token")
    public void userLoggedInAsToken(String login, String password) {
        apiRequests.gettingBearerToken();
        signInPage.userLoggedInAs(login, password);
    }

    @Given("new league with {string} name creates via API request")
    public void leagueApiCreate(String leagueName) {
        apiRequests.requestToLeagueCreateAPI(leagueName);
    }

    @And("delete created league via API")
    public void deleteCreatedLeague() {
        apiRequests.requestToDeleteLeague();
    }

    @Given("new championship with {string} name creates via API")
    public void createCompetitionAPI(String competitionName) {
        apiRequests.requestToChampCreateAPI(competitionName);
    }
}
