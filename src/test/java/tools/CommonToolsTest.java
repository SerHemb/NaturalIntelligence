package tools;

import org.junit.Test;

import java.util.logging.Logger;

public class CommonToolsTest {

    Logger logger = Logger.getAnonymousLogger();

    @Test
    public void buildURL() {
        CommonTools commonTools = new CommonTools();
        String baseURL = "easychamp.com";
        String result = commonTools.buildCompetitionURL(baseURL);

        logger.info(result);
    }
}