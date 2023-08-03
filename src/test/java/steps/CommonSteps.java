package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.APIRequestTools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;
import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class CommonSteps {

    private final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(25);
    WebDriverWait wait;
    WebDriver driver;


    private Map<String, Object> scenarioContext = new HashMap<>();

    Logger logger = Logger.getLogger(CommonSteps.class);

    public CommonSteps() {
        driver = Setup.driver;
        wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
    }

    @Given("open {string}")
    public void open(String address) {
        driver.get(address);
    }

    @Then("type {string} in {string}")
    public void typeIn(String value, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.sendKeys(value);
    }

    @When("type {string} in {string} for {int} times")
    public void typeInForTimes(String value, String target, int times) {
        WebElement foundElement = driver.findElement(getByObject(target));

        for (int i = 0; i < times; i++) {
            foundElement.sendKeys(value);
        }
    }

    @And("send key {string} to {string}")
    public void sendKeyTo(String keyParam, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.sendKeys(Keys.valueOf(keyParam));
    }

    @And("wait visibility and send key {string} to {string}")
    public void sendKeyToVisible(String keyParam, String target) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
            driver.findElement(getByObject(target)).sendKeys(keyParam);
            System.out.println("Element clicked successfully!");
        } catch (Exception e) {
            System.err.println("Element not found or could not be clicked: " + e.getMessage());
        }
    }

    @When("click to {string}")
    public void clickTo(String target) {
        sleep(1000);
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.click();
    }

    @When("wait when element {string} visible and click")
    public void ClickToVisible(String target) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
            driver.findElement(getByObject(target)).click();
            System.out.println("Element clicked successfully!");
        } catch (Exception e) {
            System.err.println("Element not found or could not be clicked: " + e.getMessage());
        }
    }

    @And("rightClick to {string}")
    public void rightClickTo(String target) {
        Actions action = new Actions(driver);
        WebElement foundElement = driver.findElement(getByObject(target));
        action.contextClick(foundElement).perform();
    }


    @And("click to {string} {int} times")
    public void clickToTimes(String locator, int times) {
        WebElement element = driver.findElement(getByObject(locator));

        for (int i = 0; i < times; i++) {
            element.click();
        }
    }

    @And("wait for {string} is visible")
    public void waitForIsVisible(String target) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
        wait.until(ExpectedConditions.elementToBeClickable(getByObject(target)));
    }

    @When("wait for {string} is visible for {int} millis")
    public void wait_for_is_visible_for_sec(String target, Integer amountOfMillis) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofMillis(amountOfMillis));
        localWait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
        localWait.until(ExpectedConditions.elementToBeClickable(getByObject(target)));
    }

    @Then("assert text {string} presented in {string}")
    public void assertTextPresentedIn(String text, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        String elementText = foundElement.getText();

        String message = "Text \"" + text + "\" \nin " + target + " is not presented. \nActual text is \"" + elementText + "\"";
        assertTrue(message, elementText.contains(text));
    }

    @Then("assert element {string} displayed")
    public void assertElementDisplayed(String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        assertEquals(true, foundElement.isDisplayed());
    }

    @Then("assert element {string} not displayed")
    public void assertElementNotDisplayed(String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        assertEquals(false, foundElement.isDisplayed());
    }

    @And("clear field {string}")
    public void clearField(String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.clear();
    }

    @Then("alert with {string} is present")
    public void alertWithStringIsPresent(String expectedAlert) {
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals(expectedAlert, alertMessage);
    }

    @And("click back button")
    public void goBack() {
        driver.navigate().back();
    }

    @Then("assert button {string} is disabled")
    public void assertButtonIsDisabled(String target) {
        WebElement button = driver.findElement(getByObject(target));
        assertEquals(false, button.isEnabled());
    }

    @Then("assert button {string} is enabled")
    public void assertButtonIsEnabled(String target) {
        WebElement button = driver.findElement(getByObject(target));
        assertEquals(true, button.isEnabled());

    }

    @Then("assert page title is {string}")
    public void assertPageTitleIs(String currentTitle) {
        String pageTitle = driver.getTitle();
        assertEquals(currentTitle, pageTitle);
    }

    @Then("assert element {string} present")
    public void assertElementPresent(String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        assertTrue(foundElement.isDisplayed());
    }

    @Then("assert that {string} checked")
    public void assert_that_checked(String locator) {
        WebElement checkbox = driver.findElement(getByObject(locator));
        String isChecked = checkbox.getAttribute("checked");
        assertNotNull(isChecked);
    }

    @And("assert that {string} not checked")
    public void assertThatNotChecked(String locator) {
        WebElement checkbox = driver.findElement(getByObject(locator));
        String isChecked = checkbox.getAttribute("checked");
        assertNull(isChecked);
    }

    @And("checkbox {string} should be selected {string}")
    public void checkboxShouldBeSelected(String locator, String booleanParam) {
        WebElement element = driver.findElement(getByObject(locator));

        if (booleanParam.equalsIgnoreCase("true")) {
            Assert.assertTrue("element was not selected", element.isSelected());
        } else {
            Assert.assertFalse("element was selected", element.isSelected());
        }

    }

    @And("select text {string} in {string} dropdown")
    public void selectTextInDropdown(String visibleText, String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        Select select = new Select(element);

        select.selectByVisibleText(visibleText);
    }

    @Then("option {string} is selected in {string} dropdown")
    public void optionIsSelectedInDropdown(String visibleText, String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        Select select = new Select(element);
        WebElement selected = select.getFirstSelectedOption();
        String selectedText = selected.getText();
        assertEquals(selectedText, visibleText);
    }

    @When("set value of {string} to {string}")
    public void setValueOfTo(String locator, String value) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "document.getElementById('" + locator + "').setAttribute('value', '" + value + "')";
        jse.executeScript(script);
    }

    @When("submit {string} input")
    public void submitInput(String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        element.submit();
    }

    @Then("sleep for {int} seconds")
    public void sleepForSecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("new user created")
    public void newUserCreated() throws IOException {
        String userName = "AutoUser" + UUID.randomUUID();
        String email = "AutomationTestUser001@gmail.com";
        String password = "1112223333444Password!";
        Response response;
        try {
            response = APIRequestTools.sendCreateUserRequest(userName, email, password);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            logger.info(responseBody);
        } else {
            logger.info("Request failed with status code: " + response.code());
        }
    }

    @Given("scroll to element {string}")
    public void scrollToElement(String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    @Then("assert URL is equal to {string}")
    public void assertURLIsEqualTo(String text) {
        String URL = driver.getCurrentUrl();
        assertEquals(text, URL);
    }

    @And("save text from {string} as {string}")
    public void saveTextFromAs(String locator, String variableName) {
        WebElement element = driver.findElement(getByObject(locator));
        String text = element.getText();
        scenarioContext.put(variableName, text);
    }

    @And("log a {string} from context")
    public void logAVariableFromContext(String variableName) {
        String valueFromContext = (String) scenarioContext.get(variableName);
        logger.info(valueFromContext);
    }
}