package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.CommonSteps;
import tools.APIRequests;
import java.time.Duration;
import java.util.UUID;
import static org.junit.Assert.assertTrue;
import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class CompetitionPage extends BasePage {
    private final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(25);

    APIRequests apiRequests = new APIRequests();
    AdminPanelPage adminPage = new AdminPanelPage();
    CommonSteps commonSteps = new CommonSteps();
    private String competitionStoredName;

    UUID uuid = UUID.randomUUID();
    String uuidString = uuid.toString().substring(0, 5);
    String nameRequired = "CompetitionName" + uuidString;
    String friendlyName = "FriendlyName" + uuidString;
    String subtype = "SybType" + uuidString;
    public String description = "description" + uuidString;
    /**
     * Competition page locators
     */
    public final String CREATE_NEW_COMPETITION_BUTTON = "xpath=//button[normalize-space()='New Champ']";
    public final String COMPETITION_DESCRIPTION_FIELD = "xpath=//div[@class='ql-editor ql-blank']";
    public String COMPETITION_NAME_FIELD = "xpath=//input[@name='name']";
    public final String COMPETITION_FRIENDLY_FIELD = "xpath=//input[@name='alternative']";
    public final String COMPETITION_SUBTYPE_FIELD = "xpath=//input[@placeholder='e.g. for Football - 8x8, 5x5, U10 etc']";
    public final String LEAGUE_SELECT_DROPDOWN = "xpath=//div[@id='mui-component-select-champLeagueId']";
    public final String COMPETITION_IMAGE_UPLOAD = "xpath=//input[@type='file'][1]";
    public final String COMPETITION_IMAGE_PATH = "/src/test/resources/files/image.png";
    public final String COMPETITION_SAVE_BUTTON = "xpath=//button[text()='Save']";
    public String competitionCartNameVerify = "xpath=//div[@class='SportEntityCard_card__SQ6lG'][position()=1]/a/div[3]";
    public String competitionCartImage = "xpath=//div[@class='SportEntityCard_card__SQ6lG'][position()=1]/a/div/div/img";

    /**
     * Competition page methods
     */

    public void selectLeagueDropdown(String leagueName) {
        commonSteps.clickTo(String.valueOf(driver.findElement(By.xpath("//li[text()='" + leagueName + "']"))));
    }

    public void clickNotActiveSaveCompetitionButton() {
        WebElement saveActive = driver.findElement(getByObject(COMPETITION_SAVE_BUTTON));
        boolean isActive = saveActive.isEnabled();
        Assert.assertFalse("Button is active", isActive);
    }
    public void assertCompetitionOnPage() {
        sleep(1000);
        driver.findElement(getByObject(COMPETITION_SAVE_BUTTON)).click();
        sleep(1000);
        commonSteps.clickTo(adminPage.COMPETITIONS);
        sleep(2000);
        String actualCompOnPageList = driver.findElement(getByObject(competitionCartNameVerify)).getAttribute("innerText");
        Assert.assertEquals(actualCompOnPageList, competitionStoredName);
    }

    public void imageCompetitionAssert() {
        sleep(1000);
        driver.findElement(getByObject(COMPETITION_SAVE_BUTTON)).click();
        sleep(1000);
        commonSteps.clickTo(adminPage.COMPETITIONS);
        sleep(1000);
        WebElement image = driver.findElement(getByObject(competitionCartImage));
        assertTrue(image.isDisplayed());
    }
}
