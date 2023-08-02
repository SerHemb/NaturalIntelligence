package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static tools.CommonTools.*;

public class ConfirmationFormPage extends BasePage {
    private static final String FIRSTNAME_INPUT = "id=FirstName";
    private static final String FIRSTNAME_VALUE = "TestUser";
    private static final String LASTNAME_INPUT = "id=LastName";
    private static final String LASTNAME_VALUE = "Automation";
    private static final String BIRTHDAY_INPUT = "id=Birthday";
    private static final String BIRTHDAY_VALUE = "2000-01-19";
    private static final String GENDER_INPUT = "id=Gender";
    private static final String GENDER_VALUE = "Male";

    public void filloutForm() {
        driver.findElement(getByObject(FIRSTNAME_INPUT)).sendKeys(FIRSTNAME_VALUE);
        driver.findElement(getByObject(LASTNAME_INPUT)).sendKeys(LASTNAME_VALUE);
        driver.findElement(getByObject(BIRTHDAY_INPUT)).sendKeys(BIRTHDAY_VALUE);
        //Select gender
        WebElement element = driver.findElement(getByObject(GENDER_INPUT));
        element.findElement(By.xpath("//option[. = '" + GENDER_VALUE + "']")).click();
        //Select nationality
        WebElement dropdown = driver.findElement(By.id("nationality-dropdown"));
        dropdown.findElement(By.xpath("//option[. = 'Venezuela']")).click();
        driver.findElement(By.cssSelector(".text-button")).click();
    }
}
