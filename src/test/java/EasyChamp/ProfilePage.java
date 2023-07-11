package EasyChamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]")
    private WebElement userMenu;

    @FindBy(className = "ModalMenuContainer_user__9L9pn")
    private WebElement userInfo;

    @FindBy(className = "ModalMenuContainer_logout__Flqqb")
    private WebElement logoutBtn;

    public void entryMenu() {
        userMenu.click();}

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ModalMenuContainer_user__9L9pn")));
        String userName = userInfo.getAttribute("innerText");
        return userName;
    }


    public void userLogout() {

        logoutBtn.click();}


}
