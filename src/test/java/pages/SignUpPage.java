package pages;

import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class SignUpPage extends BasePage {
    private static final String EMAIL_INPUT = "id=Email";
    private static final String PASSWORD_INPUT = "id=Password";
    private static final String PASSWORD_VALUE = "CocojabmO123";
    private static final String CONFIRM_PASS_VALUE = "id=ConfirmPassword";
    private static final String SUBMIT_BUTTON = "id=submit-btn";
    private static final String INFO_TEXT = "css=.text-info";
    private static final String USERNAME_INPUT = "id=Username";
    private static String USERNAME_VALUE = "AutomationUser";
    private static String EMAIL_ID_VALUE = "testAuto@gbwb3oed.mailosaur.net";

    public void enterInformation() {
        driver.findElement(getByObject(USERNAME_INPUT)).sendKeys(generateUsername());
        driver.findElement(getByObject(EMAIL_INPUT)).sendKeys(generateEMailID());
        driver.findElement(getByObject(PASSWORD_INPUT)).sendKeys(PASSWORD_VALUE);
        driver.findElement(getByObject(CONFIRM_PASS_VALUE)).sendKeys(PASSWORD_VALUE);

        saveUsernameAndPassword();
    }

    private void saveUsernameAndPassword() {
        context.put("TEST_USERNAME", USERNAME_VALUE);
        context.put("TEST_USER_PASSWORD", PASSWORD_VALUE);
    }

    private CharSequence generateUsername() {
        USERNAME_VALUE = USERNAME_VALUE + UUID.randomUUID().toString().substring(0, 8);
        return USERNAME_VALUE;
    }


    public String generateEMailID() {
        String domain = EMAIL_ID_VALUE.split("@")[1];
        EMAIL_ID_VALUE = USERNAME_VALUE + "@" + domain;
        return EMAIL_ID_VALUE;
    }


    public void submit() {
        driver.findElement(getByObject(SUBMIT_BUTTON)).click();
    }

    public void assertConfirmationMessage() {
        wait.forElementToBeDisplayed(10, getByObject(INFO_TEXT), "INFO_TEXT");
        WebElement element = driver.findElement(getByObject(INFO_TEXT));
        assertEquals(true, element.isDisplayed());

        sleep(3000);
        String text = element.getText();
        assertEquals(true, text.startsWith("We have sent you an email to "));
    }
}
