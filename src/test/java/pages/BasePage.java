package pages;

import hooks.Setup;
import hooks.Wait;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

import java.util.HashMap;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;
    protected CommonSteps steps;
    HashMap<String, Object> context;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
        context = new HashMap<>();
        steps = new CommonSteps();
    }

}
