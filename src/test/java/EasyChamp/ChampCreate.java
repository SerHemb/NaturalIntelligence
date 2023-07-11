package EasyChamp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChampCreate {
    public WebDriver driver;
    Faker faker = new Faker();

    public ChampCreate(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}
    //Generate random names
    String nameRequired = faker.name().fullName();
    String friendlyName = faker.name().username();
    String subtype = faker.name().nameWithMiddle();
    String description = faker.regexify("[a-z1-9]{50}");


    //Web elements/Buttons
    @FindBy(xpath = "//button[normalize-space()='Not Published']")   // not publish competitions button
    private WebElement notPublishedW;
    @FindBy(xpath = "//input[@placeholder='Search']")          // global search field
    private WebElement globalSearch;
    @FindBy(xpath = "//button[@type='submit']") //save competition button
    private WebElement saveCompBtnW;
    @FindBy(xpath = "//div[@class='MainLayoutHeaderContainer_buttons__1vnLa']//*[name()='svg']") //navigation Drawer (Not Logged in)
    private WebElement navDrawer;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]")
    private WebElement nawDrawerL;
    @FindBy(xpath = "//div[@class='MainLayoutHeaderContainer_buttons__1vnLa']//*[name()='svg']")  //admin panel button
    private WebElement adminPanel;
    @FindBy(xpath = "//span[normalize-space()='Competitions']")   //go to Competitions button
    private WebElement competitionPage;
    @FindBy(xpath = "//button[normalize-space()='New Champ']")  // new Championship button
    private WebElement newChampButton;
    @FindBy(className = "SportEntityCard_card__SQ6lG")    // delete Competition button ??????????
    private WebElement deleteComp;
    @FindBy(xpath = "//div[text()='Logout']")  // log out Button
    private WebElement logOutBtnW;


    //Web elements/Fields
    @FindBy(xpath = "//input[@name='name']") // Competition name field
    private WebElement nameRequiredW;
    @FindBy(xpath = "//input[@name='alternative']") // Friendly name field
    private WebElement friendlyNameW;
    @FindBy(xpath = "//input[@placeholder='e.g. for Football - 8x8, 5x5, U10 etc']") // Subtype field
    private WebElement subtypeW;
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")  // Description field
    private WebElement descriptionW;

    //Web elements/Dropdown menus
    @FindBy(xpath = "//div[@id='mui-component-select-champLeagueId']")  //league dropdown
    private WebElement leagueDropdownW;
    @FindBy(xpath = "//li[text()='Natural Intelligence Legue']")   // league dropdown menu select
    private WebElement leagueChooseW;

    //Web elements/public-not public toggle
    @FindBy(xpath = "//input[@name='isPublished']")    // switch toggle
    private WebElement toggle;

    //Web elements/Upload image
    @FindBy(xpath = "//input[@id='constructor-icon-file11']")
    private WebElement imageCompW;
////input[@type='file'][1]

    //Methods
    public void clickNotPublishBtn() {
        notPublishedW.click();}
    public void clickNavDrawer() {
        navDrawer.click();}           //click Navigation drawer
    public void clickAdminPanel() {
        adminPanel.click();}          // click Admin panel
    public void openCompPage() {
        competitionPage.click();}     // click Competition page button
    public void createNewChampButton() {
        newChampButton.click();}     // click Create New competition button
    public void saveBtnCompImg() {
        WebDriverWait waitSave = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitSave.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Delete']")));
        saveCompBtnW.click();
        waitSave.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")));}       // Save competition button for image upload
    public void saveCompBtn() {
        WebDriverWait waitPopUp = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitPopUp.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")));}    // Save competition
    public void switchToggle() {
        toggle.click();}             // Switch toggle button
    public void typeLeague() {
        leagueDropdownW.click();}    // click league dropdown menu
    public void leagueChoose() {
        leagueChooseW.click();}     // click on list of league dropdown menu
    public void uploudImageComp(String pic) {
        imageCompW.sendKeys(pic);}        // Upload competition image

    //Type fields methods
    public void typename() {
        nameRequiredW.sendKeys(nameRequired);}  // type Competition name
    public void typefriendlyName() {
        friendlyNameW.sendKeys(friendlyName);}  // type Friendly name
    public void typeSubtype() {
        subtypeW.sendKeys(subtype);}      // type Subtype field
    public void typeDescription() {
        descriptionW.sendKeys(description);} // type Description field
    public void logOut(){
        nawDrawerL.click();
        logOutBtnW.click();}               // Log out
    public void globalSearchName() {
        globalSearch.sendKeys(nameRequired);}// Global search by Name


    // All in one methods
    public void newChampionshipCreate() {
        navDrawer.click();
        adminPanel.click();
        competitionPage.click();
        newChampButton.click();}    // New championship create One method
    public void deleteCompetition() {
        navDrawer.click();
        adminPanel.click();
        competitionPage.click();
        deleteComp.click();}        // Delete competition One method ????????????















}