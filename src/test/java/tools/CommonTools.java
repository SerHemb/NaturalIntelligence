package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonTools {

    public static int extractInteger(String stringValue) {
        String[] array = stringValue.split(" ");
        String numberOfResults = array[1];
        String replacedComma = numberOfResults.replace(",", "");
        int parsedInteger = Integer.parseInt(replacedComma);

        return parsedInteger;
    }

    public static int parseResults(WebElement element) {
        String elementText = element.getText();
        return extractInteger(elementText);
    }

    public static By getByObject(String target) {
        if (target.startsWith("name")) {
            String locatorValue = target.split("=")[1];
            return By.name(locatorValue);
        } else if (target.startsWith("id")) {
            String locatorValue = target.split("=")[1];
            return By.id(locatorValue);
        } else if (target.startsWith("linkText")) {
            String locatorValue = target.split("=")[1];
            return By.linkText(locatorValue);
        } else if (target.startsWith("xpath")) {
            String locatorValue = target.substring(6);
            return By.xpath(locatorValue);
        } else if (target.startsWith("css")) {
            String locatorValue = target.split("=")[1];
            return By.cssSelector(locatorValue);
        }

        return null;
    }

    public String buildCompetitionURL(String baseURLParam) {
        //https://dev.easychamp.com/admin/competitions/edit/0383ed35-8120-4a17-ab29-ad5b74c41926?tabs=Schedule
        String protocol = "https://";
        String baseURL = baseURLParam;
        String endpoint = "/admin/competitions/edit/";
        String competitionID = "0383ed35-8120-4a17-ab29-ad5b74c41926";
        String params = "tabs=Schedule";

        return protocol + baseURL + endpoint + competitionID + "?" + params;
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
