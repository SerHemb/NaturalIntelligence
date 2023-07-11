import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
public class easyChamp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/hembei//Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://easychamp.com/");
            Thread.sleep(5000);

            //Login
            driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
            driver.findElement(By.xpath("//input[@id='EmailOrUsername']")).sendKeys("iserhiy888@gmail.com");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("NewPass1");
            driver.findElement(By.xpath("//div[@class='text-button']")).click();
            Thread.sleep(2000);

            //Champ create
            driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M3 18h18v-')]")).click();
            String inner = driver.findElement(By.className("ModalMenuContainer_user__9L9pn")).getAttribute("innerText");
            System.out.println("innerText " + inner);








        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // driver.quit();
        }
    }

}