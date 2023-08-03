package steps;

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

    @And("admin types {string} in Name field and selects {string} from dropdown menu")
    public void requiredCompetitionFields(String competitionName, String leagueName) {
        sleep(2000);
        driver.findElement(getByObject(competitionPage.COMPETITION_NAME_FIELD)).sendKeys(competitionName);
        commonSteps.clickToVisible(competitionPage.LEAGUE_SELECT_DROPDOWN);
        competitionPage.selectLeagueDropdown(leagueName);
    }

    @When("browser is on new competition creation page")
    public void createNewCompetitionPage() {
        commonSteps.clickToVisible(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        commonSteps.clickToVisible(competitionPage.CREATE_NEW_COMPETITION_BUTTON);
    }

    @Then("the cart with {string} title presents on competitions list page")
    public void saveAndAssertCreatedCompetition(String expectCompetitionName) {
        sleep(1000);
        commonSteps.clickToVisible(competitionPage.COMPETITION_SAVE_BUTTON);
        sleep(1000);
        commonSteps.clickToVisible(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        sleep(1000);
        commonSteps.assertTextPresentedIn(expectCompetitionName, competitionPage.COMPETITION_CART_TITLE);
    }

    @And("admin types {string} in Name field and doesn't select league from dropdown menu")
    public void typeNameCompetitionField(String competitionName) {
        sleep(1000);
        commonSteps.sendKeyToVisible(competitionName, competitionPage.COMPETITION_NAME_FIELD);
    }

    @Then("save button is not highlighted and not clickable")
    public void assertSaveCompetitionButton() {
        try {
        commonSteps.assertButtonIsDisabled(competitionPage.COMPETITION_SAVE_BUTTON);
        sleep(1000);
        commonSteps.clickToVisible(competitionPage.COMPETITION_SAVE_BUTTON);
        System.out.println("Button is not clickable");
    } catch (Exception e) {
        System.err.println("Button is highlighted and clickable: " + e.getMessage());
    }
    }
}
