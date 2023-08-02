package pages;

public class AdminPanelPage extends BasePage {
    private String PLAYERS_MENU_BUTTON = "xpath=//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div[4]/a/button";

    public void navigateToPlayers() {
        steps.clickTo(PLAYERS_MENU_BUTTON);
    }
}
