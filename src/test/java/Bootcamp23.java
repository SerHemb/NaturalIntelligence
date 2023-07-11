import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Bootcamp23 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/hembei/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
// Site loading
            driver.get("https://video-converter.com/");
            System.out.println("Site 'video-converter.com' opened......OK!");
            Thread.sleep(5000);

// Upload file
            WebElement upload = driver.findElement(By.xpath("//input[@type='file'][1]"));
            upload.sendKeys("/home/hembei/Desktop/HomeworkVideo.mp4");
            System.out.println("Waiting for uploading video.....");

// Waiting for downloading video
            Boolean waitingElement = (new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='filename']"),"HomeworkVideo.mp4")));

            WebElement video = driver.findElement(By.xpath("//span[@class='filename']"));
            String videoAssert = video.getAttribute("outerText");
            Assert.assertEquals(videoAssert, "HomeworkVideo.mp4");
            System.out.println("Video upload successfully........OK!");
            Thread.sleep(5000);

// Video settings change
            driver.findElement(By.xpath("//div[contains(text(),'mov')]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='col_2']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='hd720p']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='button_1_inner_2'][normalize-space()='Convert']")).click();
            System.out.println("Video Settings changed......OK!");
            Thread.sleep(3000);

// Waiting for converting video
            System.out.println("Waiting for converting video.......");
            Boolean waitingElement2 = (new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[@id='download_file_link']"), "Download")));
            System.out.println("Video converted successfully........OK!");
            Thread.sleep(3000);

// Download video
            WebElement result = driver.findElement(By.id("file_ready_text"));
            String resultvar = result.getAttribute("innerText");
            System.out.println(resultvar);
            Thread.sleep(6000);

            if (resultvar != null) {
                Assert.assertEquals(resultvar, "Сonversionomplete");
                System.out.println("Done...now you can download video");
                driver.findElement(By.id("download_file_link")).click();
                System.out.println("Downloaded complete.......OK");
            } else {
                System.out.println("Something went wrong...You need to repeat a test");
                driver.navigate().refresh();
            }



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }

}