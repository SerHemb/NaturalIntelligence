package EasyChamp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CompetitionsTestSuite {
    public static ChampCreate champCreate;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        Faker data = new Faker();
        champCreate = new ChampCreate(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));}


    /*@Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //loginPage.clickLogin();
        loginPage.inputPass(ConfProperties.getProperty("password"));
        loginPage.clickLogin();

        profilePage.entryMenu();

        String user = profilePage.getUserName();
        System.out.println(user);
        Assert.assertEquals(ConfProperties.getProperty("assertName"), user);}
*/




    @Test
    public void switchToPublic() {
        //log in
        loginPage.logIn();
        //Go to competition
        champCreate.newChampionshipCreate();
        champCreate.typename();
        champCreate.typefriendlyName();
        champCreate.typeSubtype();
        champCreate.typeDescription();
        champCreate.switchToggle();
        champCreate.typeLeague();
        champCreate.leagueChoose();
        champCreate.uploudImageComp(ConfProperties.getProperty("image"));
        String expected = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("defaultValue");
        champCreate.saveBtnCompImg();
        champCreate.openCompPage();
        champCreate.clickNotPublishBtn();



        champCreate.globalSearchName();
        String actual = driver.findElement(By.xpath("//div[@class='Index-searchItemContent css-1aqcyn4']")).getAttribute("textContent");
        Assert.assertEquals(actual, expected);



    }









    @AfterTest
    public static void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        champCreate.logOut();
        driver.get(ConfProperties.getProperty("loginpage"));
    }
        //driver.quit();





}
