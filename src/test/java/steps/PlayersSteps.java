package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PlayersPage;

public class PlayersSteps {

    PlayersPage playersPage = new PlayersPage();

    @And("searches for {string} player")
    public void searchForByPlayer(String playerName) {
        playersPage.searchForPlayer(playerName);
    }

    @Then("{string} is found")
    public void isFound(String playerName) {
        playersPage.assertPlayerIsVisible(playerName);
    }
}
