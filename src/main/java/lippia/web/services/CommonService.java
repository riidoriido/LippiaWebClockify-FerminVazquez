package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LoginConstants;

public class CommonService {

    public static void loginToClockify(String user, String password) {
        String userInput = System.getenv(user);
        String passwordInput = System.getenv(password);
        WebActionManager.setInput(LoginConstants.INPUT_EMAIL, userInput);
        WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, passwordInput);
    }

    public static void clickLocatorWithText(String targetText, String xpath) {
        String locator = xpath.replace("%s", targetText);
        System.out.println(locator);
        WebActionManager.click(locator);
    }


    public static void createRandomString(String concatString, int char_length, String targetText, String xpath) {
        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomString = "";

        for (int i = 0; i < char_length; i++) {
            int randomIndex = (int) (Math.random() * charPool.length());
            char randomChar = charPool.charAt(randomIndex);
            randomString += randomChar;
        }

        String locator = xpath.replace("%s", targetText);
        WebActionManager.setInput(locator, concatString + randomString);
        System.out.println(concatString+randomString);

    }

}
