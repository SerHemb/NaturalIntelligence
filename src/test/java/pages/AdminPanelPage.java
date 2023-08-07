package pages;

import steps.CommonSteps;

public class AdminPanelPage extends BasePage {
    private String PLAYERS_MENU_BUTTON = "xpath=//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div[4]/a/button";
    CommonSteps commonSteps = new CommonSteps();
    /**
     * Admin page web elements variables
     */
    public static final String LEAGUES_SIDE_BUTTON = "xpath=//span[normalize-space()='Leagues']";
    public String COMPETITIONS_SIDE_BUTTON = "xpath=//span[normalize-space()='Competitions']";
    public static final String TEAMS_SIDE_BUTTON = "xpath=//span[normalize-space()='Teams']";
    public static final String PLAYERS_SIDE_BUTTON = "xpath=//span[normalize-space()='Players']";
    public static final String MATCHES_SIDE_BUTTON = "xpath=//span[normalize-space()='Matches']";
    // from LOGO --> SEARCH FIELD
    public static final String HEADER = "xpath=//header[@class='MainLayoutHeaderContainer_wrapper__sTStD']";
    public static final String LOGO = "xpath=//div[@class='MainLayoutHeaderContainer_logo-wrapper__T1rOJ']";
    public static final String LANGUAGE_DROPDOWN = "xpath=//div[@class='MainLayoutHeaderContainer_lang__HUVut']";
    public static final String ENG_LANG = "xpath=xpath=//div[text()='English']";
    public static final String RUS_LANG = "xpath=//div[text()='Russian']";
    public static final String ESP_LANG = "xpath=//div[text()='Español']";
    public static final String SPORT_SEARCH_FIELD = "xpath=//input[@value='All Sports']";
    public static final String SPORT_SELECT_DROPDOWN_BUTTON = "xpath=//div[@class='MuiAutocomplete-endAdornment css-2iz2x6']/button[2]";
    public static final String SPORT_SEARCH_CLEAR = "xpath=//div[@class='MuiAutocomplete-endAdornment css-2iz2x6']/button[1]";
    public static final String GLOBAL_SEARCH = "xpath=//input[@placeholder='Search']";
    // from COMPETITIONS --> BURGER_MENU
    public final String COMPETITIONS = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=1]";
    public static final String CALENDAR = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=2]";
    public static final String ABOUT_US = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=3]";
    public static final String PRICING = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=3]";
    public static final String CREATE_BUTTON = "xpath=//button[text()='Create']";
    public static final String MY_PROFILE_BUTTON = "xpath=//div[@class='MainLayoutHeaderContainer_profile__G9Bst']/a[1]";
    public static final String ADMIN_PANEL_BUTTTON = "xpath=//div[@class='MainLayoutHeaderContainer_profile__G9Bst']/a[3]";
    public static final String SIGN_IN_BUTTON = "xpath=//button[text()='Sign In']";
    public static final String BURGER_MENU = "css=.ModalMenuContainer_burger__IS_VP";

    /**
     * Admin page Side buttons methods
     */
    public void navigateToPlayers() {
        commonSteps.clickTo(PLAYERS_MENU_BUTTON);
    }
}
