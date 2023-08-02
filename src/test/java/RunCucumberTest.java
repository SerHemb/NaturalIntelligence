import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"junit:target/cucumber-reports/Cucumber.xml", "html:target/detailed-report.html"},
        publish = false,
        features = {"src/test/resources/features/"},
        glue = {"/hooks", "/steps", "/support"}
)
public class RunCucumberTest {
}
