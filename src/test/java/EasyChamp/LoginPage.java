package EasyChamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}

    //Web elements
    @FindBy(xpath = "//input[@id='EmailOrUsername']")   //Find login field
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='Password']")  // Find password field and create variable
    private WebElement passField;
    @FindBy(xpath = "//div[@class='text-button']")   //Find Sign in button
    private WebElement loginBtn;

    //Methods
    public void inputLogin(String login) {
        loginField.sendKeys(login);}            //Login input
    public void inputPass(String pass) {
        passField.sendKeys(pass);}             //Method of pass input
    public void clickLogin() {
        loginBtn.click();}        //Method of sign in button click

    public void logIn() {
        inputLogin(ConfProperties.getProperty("login"));
        inputPass(ConfProperties.getProperty("password"));
        loginBtn.click();
    }

}
