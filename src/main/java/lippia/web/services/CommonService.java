package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.CommonConstants;
import lippia.web.constants.LoginConstants;

public class CommonService {

    public static void loginToClockify(String user, String password) {
        String userInput = System.getenv(user);
        String passwordInput = System.getenv(password);
        WebActionManager.setInput(LoginConstants.INPUT_EMAIL, userInput);
        WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, passwordInput);
    }

    public static void clickElement(String locator, String targetText) {
        WebActionManager.click(locator, targetText);
    }

    public static void clickButtonOrLink(String element, String targetText) {
        if (element.equals("button")){
            WebActionManager.click(CommonConstants.BUTTON_EL,targetText);
        } else {
            WebActionManager.click(CommonConstants.LINK_EL,targetText);
        }
    }



    public static void inputWithText(String targetText, String xpath, String input) {
        String locator = xpath.replace("%s", targetText);
        System.out.println(locator);
        WebActionManager.setInput(locator,input);
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
