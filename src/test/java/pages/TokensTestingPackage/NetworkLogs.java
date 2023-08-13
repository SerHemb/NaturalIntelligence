package pages.TokensTestingPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;

import org.apache.log4j.Logger;

import java.util.Optional;

public class NetworkLogs {

    public static String bearerToken;

    Logger logger = Logger.getLogger(NetworkLogs.class);

    @Test
    public void LogTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();



        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request response = request.getRequest();
            if (response.getUrl().contains("https://dev.easychamp.com/sc-standings-api/sport-types/leagues")) {
                String bearerToken = response.getHeaders().get("Authorization").toString();
                if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                    this.bearerToken = bearerToken;
                    logger.info("Bearer token: " + bearerToken);
                } else {
                    logger.info("Authorisation Bearer Token not found.");
                }

            }
        });
       driver.get("https://dev.easychamp.com/sc-security-api/Account/Login?ReturnUrl=%2Fsc-security-api%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsc-web-ui%26redirect_uri%3Dhttps%253A%252F%252Fdev.easychamp.com%252Fcallback%26response_type%3Dcode%26scope%3Dopenid%2520profile%2520email%2520sc-standings-api%2520sc-security-api%2520offline_access%26state%3D3c4848758b6e460baad4fcb810904172%26code_challenge%3DaxLSqSwYxkADLV6XwuZlrYF-sNZ19h_RYUm3HVuoByM%26code_challenge_method%3DS256%26response_mode%3Dquery%26culture%3Den");
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id='EmailOrUsername']")).sendKeys("iserhiy888@gmail.com");
       driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Parol123");
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id='submit-btn']")).click();
       Thread.sleep(5000);



       driver.quit();


    }
}
