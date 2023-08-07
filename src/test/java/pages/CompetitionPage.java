package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.CommonSteps;
import tools.APIRequests;
import tools.CommonTools;
import static pages.AdminPanelPage.HEADER;
import java.time.Duration;
import java.util.UUID;
import static tools.CommonTools.sleep;
import static tools.CommonTools.getByObject;

public class CompetitionPage extends BasePage {
    CommonSteps commonSteps = new CommonSteps();
    private final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(25);
    WebDriverWait wait;

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
    public String COMPETITION_CART_TITLE = "xpath=//div[@class='ChampsCardList_name__p6d40']";
    public String competitionCartNameVerify = "xpath=//div[@class='SportEntityCard_card__SQ6lG'][position()=1]/a/div[3]";
    public String competitionCartImage = "xpath=//div[@class='SportEntityCard_card__SQ6lG'][position()=1]/a/div/div/img";

    /**
     * Competition page methods
     */

    public void selectLeagueDropdown(String leagueName) {
        WebElement dropdownList = driver.findElement(By.xpath("//li[text()='" + leagueName + "']"));
        dropdownList.click();
    }
}
