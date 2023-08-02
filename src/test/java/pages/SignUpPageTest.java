package pages;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpPageTest {

    Logger logger = Logger.getAnonymousLogger();

    @Test
    public void generateEMailID() {
        SignUpPage signUpPage = new SignUpPage();
        String eMailID = signUpPage.generateEMailID();
        logger.log(Level.WARNING, eMailID);
    }
}