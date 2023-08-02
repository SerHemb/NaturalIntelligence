package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class PlayersPage extends BasePage {

    private String PLAYERS_LIST = "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div";
    private String SEARCH_INPUT = "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/input";

    public void waitForPlayersList() {
        steps.waitForIsVisible(PLAYERS_LIST);
    }

    public void searchForPlayer(String playerName) {
        steps.clickTo(SEARCH_INPUT);
        steps.typeIn(playerName, SEARCH_INPUT);
    }

    public void assertPlayerIsVisible(String playerName) {
        String text = driver.findElement(By.xpath("//div[@title='" + playerName + "']")).getText();
        Assert.assertEquals(playerName, text);
    }
}
