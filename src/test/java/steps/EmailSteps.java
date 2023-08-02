package steps;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import hooks.Setup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static tools.CommonTools.sleep;

public class EmailSteps {
    WebDriver driver;
    private String activationLink = "";

    public EmailSteps() {
        driver = Setup.driver;
    }

    @Then("should receive a confirmation email")
    public void userShouldReceiveAConfirmationEmail() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "7Nu8jLKVZiRDpYlNIttzNDO3yY3eCm5P";
        String serverId = "gbwb3oed";
        String serverDomain = "gbwb3oed.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSubject("Registration");

        Message message = mailosaur.messages().get(params, criteria);

        activationLink = message.html().links().get(0).href();
    }

    @Then("opens activation link in the browser")
    public void opensActivationLinkInTheBrowser() {
        driver.get(activationLink);
        sleep(1000);
    }
}
