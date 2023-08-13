package pages.TokensTestingPackage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class generateHARV2 {
    WebDriver             driver;
    BrowserMobProxyServer proxy;
    Proxy                 seleniumProxy;

    @BeforeAll
    public void setup() throws UnknownHostException {
        //Proxy Operations
        proxy = new BrowserMobProxyServer();
        proxy.start(8080);
        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        String hostIp = Inet4Address.getLocalHost().getHostAddress();
        seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
        seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        System.setProperty("webdriver.chrome.driver", "/home/hembei/Selenium");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
        seleniumCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        seleniumCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--ignore-urlfetcher-cert-requests");
        options.merge(seleniumCapabilities);
        driver = new ChromeDriver(options);
    }
    @Test
    public void browserMobProxyTest() throws InterruptedException, IOException {
        proxy.newHar("google.com");
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        Har har = proxy.getHar();
        File harFile = new File("google.har");
        har.writeTo(harFile);
    }
    @AfterAll
    public void teardown() {
        proxy.stop();
        driver.quit();
    }


}

