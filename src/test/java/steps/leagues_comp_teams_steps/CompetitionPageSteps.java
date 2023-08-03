package steps.leagues_comp_teams_steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AdminPanelPage;
import pages.CompetitionPage;
import steps.CommonSteps;
import tools.APIRequests;

import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class CompetitionPageSteps {
    APIRequests apiRequests = new APIRequests();
    AdminPanelPage adminPanelPage = new AdminPanelPage();
    CommonSteps commonSteps = new CommonSteps();
    CompetitionPage competitionPage = new CompetitionPage();

    WebDriver driver;

    public CompetitionPageSteps() {
        driver = Setup.driver;
    }

    /**
     * API steps definitions methods
     * @param leagueName
     * @param competitionName
     */
    @Given("new league with {string} name and competition with {string} name created via API")
    public void leagueAndCompetitionApiCreate(String leagueName, String competitionName) {
        apiRequests.requestToLeagueCreateAPI(leagueName);
        apiRequests.requestToChampCreateAPI(competitionName);
    }

    @Given("new championship with {string} name creates via API")
    public void createCompetitionAPI(String competitionName) {
        apiRequests.requestToChampCreateAPI(competitionName);
    }

    @Given("new league with {string} name creates via API request")
    public void leagueApiCreate(String leagueName) {
        apiRequests.requestToLeagueCreateAPI(leagueName);
    }

    @And("delete created league")
    public void leagueDeleteAPI() {
        apiRequests.requestToDeleteLeague();
    }

    /**
     * Competition page steps definitions methods
     */
    @And("types {string} text in Description field")
    public void descriptionText(String description) {
        commonSteps.clickTo(competitionPage.COMPETITION_DESCRIPTION_FIELD);
    }

    @And("admin opens a new competition creating page")
    public void clickNewChampButton() {
        commonSteps.clickTo(competitionPage.CREATE_NEW_COMPETITION_BUTTON);
    }

    @And("valid characters {string} types in Friendly text field")
    public void typeFriendly(String friendlyName) {
        commonSteps.sendKeyTo(friendlyName, competitionPage.COMPETITION_FRIENDLY_FIELD);
    }

    @Then("Save button is not active")
    public void clickNotActiveSaveCompetitionButton() {
        competitionPage.clickNotActiveSaveCompetitionButton();
    }

    @When("a browser is on competition creation page")
    public void createNewCompetition() {
        commonSteps.clickTo(adminPanelPage.COMPETITIONS);
        commonSteps.clickTo(competitionPage.CREATE_NEW_COMPETITION_BUTTON);
    }


    @Then("created competition presents on page")
    public void assertCompetitionPresentsOnPage() {
        competitionPage.assertCompetitionOnPage();
    }

    @Then("created competition with added image presents on page")
    public void assertImagePresentsOnCart() {
        competitionPage.imageCompetitionAssert();
    }

    @And("admin types {string} in Name field and selects {string} from dropdown menu")
    public void requiredCompetitionFields(String competitionName, String leagueName) {
        sleep(2000);
        driver.findElement(getByObject(competitionPage.COMPETITION_NAME_FIELD)).sendKeys(competitionName);
        commonSteps.ClickToVisible(competitionPage.LEAGUE_SELECT_DROPDOWN);
        competitionPage.selectLeagueDropdown(leagueName);
    }

    @When("browser is on new competition creation page")
    public void createNewCompetitionPage() {
        commonSteps.ClickToVisible(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        commonSteps.ClickToVisible(competitionPage.CREATE_NEW_COMPETITION_BUTTON);
    }

    @Then("the cart with {string} title presents on competitions list page")
    public void saveAndAssertCreatedCompetition(String expectCompetitionName) {
        sleep(1000);
        commonSteps.ClickToVisible(competitionPage.COMPETITION_SAVE_BUTTON);
        sleep(1000);
        commonSteps.ClickToVisible(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        sleep(1000);
        commonSteps.assertTextPresentedIn(expectCompetitionName, competitionPage.COMPETITION_CART_TITLE);

    }
}
