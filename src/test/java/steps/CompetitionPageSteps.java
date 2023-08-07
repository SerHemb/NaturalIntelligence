package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPanelPage;
import pages.BasePage;
import pages.CompetitionPage;
import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;
import org.apache.log4j.Logger;
public class CompetitionPageSteps extends BasePage {
    AdminPanelPage adminPanelPage = new AdminPanelPage();
    CommonSteps commonSteps = new CommonSteps();
    CompetitionPage competitionPage = new CompetitionPage();

    Logger logger = Logger.getLogger(CompetitionPageSteps.class);

    /**
     * Competition page steps definitions methods
     */
    @And("admin types {string} in Name field and selects {string} from dropdown menu")
    public void requiredCompetitionFields(String competitionName, String leagueName) {
        sleep(2000);
        driver.findElement(getByObject(competitionPage.COMPETITION_NAME_FIELD)).sendKeys(competitionName);
        commonSteps.clickTo(competitionPage.LEAGUE_SELECT_DROPDOWN);
        competitionPage.selectLeagueDropdown(leagueName);
    }

    @When("admin user navigates to competition creation page")
    public void createNewCompetitionPage() {
        commonSteps.clickTo(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        commonSteps.clickTo(competitionPage.CREATE_NEW_COMPETITION_BUTTON);
    }

    @Then("the cart with {string} title presents on competitions list page")
    public void saveAndAssertCreatedCompetition(String expectCompetitionName) {
        sleep(1000);
        commonSteps.clickTo(competitionPage.COMPETITION_SAVE_BUTTON);
        sleep(1000);
        commonSteps.clickTo(adminPanelPage.COMPETITIONS_SIDE_BUTTON);
        sleep(2000);
        commonSteps.assertTextPresentedIn(expectCompetitionName, competitionPage.COMPETITION_CART_TITLE);
    }

    @And("admin types {string} in Name field and doesn't select league from dropdown menu")
    public void typeNameCompetitionField(String competitionName) {
        sleep(1000);
        commonSteps.sendKeyTo(competitionName, competitionPage.COMPETITION_NAME_FIELD);
    }

    @Then("save button is not highlighted and not clickable")
    public void assertSaveCompetitionButton() {
        try {
        commonSteps.assertButtonIsDisabled(competitionPage.COMPETITION_SAVE_BUTTON);
        sleep(1000);
        commonSteps.clickTo(competitionPage.COMPETITION_SAVE_BUTTON);
        logger.info("Button located " + getByObject(competitionPage.COMPETITION_SAVE_BUTTON) + " is not clickable" );
    } catch (Exception e) {
        logger.info("Button located " + getByObject(competitionPage.COMPETITION_SAVE_BUTTON) + " is highlighted and clickable:" );
        }
    }

}
