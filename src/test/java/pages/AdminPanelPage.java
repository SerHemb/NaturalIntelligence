package pages;

import steps.CommonSteps;

public class AdminPanelPage extends BasePage {
    private String PLAYERS_MENU_BUTTON = "xpath=//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div[4]/a/button";
    CommonSteps commonSteps = new CommonSteps();
    /**
     * Admin page web elements variables
     */
    private static final String LEAGUES_SIDE_BUTTON = "xpath=//div[@class='VerticalTabButtons_tabs__gmRXG']/div[1]";
    private static final String COMPETITIONS_SIDE_BUTTON = "xpath=//div[@class='VerticalTabButtons_tabs__gmRXG']/div[2]";
    private static final String TEAMS_SIDE_BUTTON = "xpath=//div[@class='VerticalTabButtons_tabs__gmRXG']/div[3]";
    private static final String MATCHES_SIDE_BUTTON = "xpath=//div[@class='VerticalTabButtons_tabs__gmRXG']/div[4]";
    private static final String REFEREES_SIDE_BUTTON = "xpath=//div[@class='VerticalTabButtons_tabs__gmRXG']/div[5]";
    // from LOGO --> SEARCH FIELD
    private static final String LOGO = "xpath=//div[@class='MainLayoutHeaderContainer_logo-wrapper__T1rOJ']";
    private static final String LANGUAGE_DROPDOWN = "xpath=//div[@class='MainLayoutHeaderContainer_lang__HUVut']";
    private static final String ENG_LANG = "xpath=xpath=//div[text()='English']";
    private static final String RUS_LANG = "xpath=//div[text()='Russian']";
    private static final String ESP_LANG = "xpath=//div[text()='Español']";
    private static final String SPORT_SEARCH_FIELD = "xpath=//input[@value='All Sports']";
    private static final String SPORT_SELECT_DROPDOWN_BUTTON = "xpath=//div[@class='MuiAutocomplete-endAdornment css-2iz2x6']/button[2]";
    private static final String SPORT_SEARCH_CLEAR = "xpath=//div[@class='MuiAutocomplete-endAdornment css-2iz2x6']/button[1]";
    private static final String GLOBAL_SEARCH = "xpath=//input[@placeholder='Search']";
    // from COMPETITIONS --> BURGER_MENU
    private static final String COMPETITIONS = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=1]";
    private static final String CALENDAR = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=2]";
    private static final String ABOUT_US = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=3]";
    private static final String PRICING = "xpath=(//div[@class='MainLayoutHeaderContainer_link__y_8w_'])[position()=3]";
    private static final String CREATE_BUTTON = "xpath=//button[text()='Create']";
    public static final String MY_PROFILE_BUTTON = "xpath=//div[@class='MainLayoutHeaderContainer_profile__G9Bst']/a[1]";
    private static final String ADMIN_PANEL_BUTTTON = "xpath=//div[@class='MainLayoutHeaderContainer_profile__G9Bst']/a[3]";
    private static final String SIGN_IN_BUTTON = "xpath=//button[text()='Sign In']";
    private static final String BURGER_MENU = "css=.ModalMenuContainer_burger__IS_VP";
    /**
     * Admin page Side buttons methods
     */
    public void clickLeaguesSideButton() {commonSteps.clickTo(LEAGUES_SIDE_BUTTON);}
    public void clickCompetitionsSideButton() {commonSteps.clickTo(COMPETITIONS_SIDE_BUTTON);}
    public void clickTeamsSideButton() {commonSteps.clickTo(TEAMS_SIDE_BUTTON);}
    public void clickMatchesSideButton() {commonSteps.clickTo(MATCHES_SIDE_BUTTON);}
    public void clickRefereesSideButton() {commonSteps.clickTo(REFEREES_SIDE_BUTTON);}
    /**
     * Admin page Top side buttons methods
     */
    public void clickLogo() {commonSteps.clickTo(LOGO);}
    public void clickLanguageDropdown() {commonSteps.clickTo(LANGUAGE_DROPDOWN);}
    public void clickEngLanguage() {commonSteps.clickTo(ENG_LANG);}
    public void clickRusLanguage() {commonSteps.clickTo(RUS_LANG);}
    public void clickEspLanguage() {commonSteps.clickTo(ESP_LANG);}

    // Sport select field
    public void clickSportSearch() {commonSteps.clickTo(SPORT_SEARCH_FIELD);}
    public void clickSportSelectDropdown() {commonSteps.clickTo(SPORT_SELECT_DROPDOWN_BUTTON);}
    public void clickClearSportSearch() {commonSteps.clickTo(SPORT_SEARCH_CLEAR);}

    // Global Search
    public void globalSearch() {commonSteps.clickTo(GLOBAL_SEARCH);}

    // Top right side of Admin panel
    public void clickAllCompetitionsButton() {commonSteps.clickTo(COMPETITIONS);}
    public void clickCalendar() {commonSteps.clickTo(CALENDAR);}
    public void clickAboutUs() {commonSteps.clickTo(ABOUT_US);}
    public void clickPricing() {commonSteps.clickTo(PRICING);}
    public void clickCreateButton() {commonSteps.clickTo(CREATE_BUTTON);}
    public void clickMyProfile() {commonSteps.clickTo(MY_PROFILE_BUTTON);}
    public void clickAdminPane() {commonSteps.clickTo(ADMIN_PANEL_BUTTTON);}
    public void clickSignInButton() {commonSteps.clickTo(SIGN_IN_BUTTON);}
    public void clickBurgerMenu() {commonSteps.clickTo(BURGER_MENU);}
    public void navigateToPlayers() {
        commonSteps.clickTo(PLAYERS_MENU_BUTTON);
    }
}
