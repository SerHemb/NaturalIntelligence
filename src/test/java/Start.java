import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class Start {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/hembei//Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://easychamp.com/");
            Thread.sleep(3000);
            //Login
            driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
            driver.findElement(By.xpath("//input[@id='EmailOrUsername']")).sendKeys("iserhiy888@gmail.com");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("NewPass1");
            driver.findElement(By.xpath("//div[@class='text-button']")).click();









        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // driver.quit();
        }
    }

}