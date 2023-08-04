package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.support.FindBy;
import pages.AdminPanelPage;
import pages.PlayersPage;

public class AdminPanelSteps {
    private AdminPanelPage adminPanelPage = new AdminPanelPage();
    private PlayersPage playersPage = new PlayersPage();

    @When("user navigates to Players in Admin panel")
    public void userNavigatesToPlayersInAdminPanel() {
        adminPanelPage.navigateToPlayers();
        playersPage.waitForPlayersList();
    }
}
