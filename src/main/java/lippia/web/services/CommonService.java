package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.CommonConstants;
import lippia.web.constants.LoginConstants;
import org.testng.Assert;


public class CommonService {

    public static void navigateToClockify() {
        WebActionManager.navigateTo("https://clockify.me");
    }

    public static void loginDataFull(String locator) {
        try {
            String userEnv = System.getenv("clockifyUSR");
            String passwordEnv = System.getenv("clockifyPSW");
            switch (locator) {
                case "email":
                    WebActionManager.waitVisibility(LoginConstants.INPUT_EMAIL);
                    WebActionManager.setInput(LoginConstants.INPUT_EMAIL, userEnv);
                    break;
                case "password":
                    WebActionManager.waitVisibility(LoginConstants.INPUT_PASSWORD);
                    WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, passwordEnv);
                    break;
                default:
                    System.out.println(locator + " does not match with case or is inexistent");
            }
        } catch (Error e) {
            System.out.println("Unable to get sysEnv.");
        }


    }

    public static void loginToClockify() {
        WebActionManager.click(LoginConstants.LOGIN_BTN_BY_TEXT," Log in manually ");
        try {
            String userEnv = System.getenv("clockifyUSR");
            String passwordEnv = System.getenv("clockifyPSW");

            WebActionManager.waitVisibility(LoginConstants.INPUT_EMAIL);
            WebActionManager.setInput(LoginConstants.INPUT_EMAIL, userEnv);

            WebActionManager.waitVisibility(LoginConstants.INPUT_PASSWORD);
            WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, passwordEnv);


        } catch (Error e) {
            System.out.println("Unable to get sysEnv.");
        }
        WebActionManager.click(LoginConstants.BUTTON_LOGIN_XPATH);
    }

    public static void verifyLoggedIn() {
        WebActionManager.waitVisibility(CommonConstants.TRACKER_TAB);
        Assert.assertTrue(WebActionManager.isVisible(CommonConstants.TRACKER_TAB),"User is either offline or element is not present.");
    }

    public static void clickButton(String targetText) {
        WebActionManager.click(CommonConstants.BUTTON_EL, targetText);
    }

    public static void clickLink(String targetText) {
        WebActionManager.click(CommonConstants.LINK_EL, targetText);
    }

    public static void inputText(String inputText, String locator) {
        WebActionManager.setInput(CommonConstants.INPUT_EL, inputText, true, false, locator);
    }

    public static void buttonNotClickeable(String locator) {
        String buttonState = WebActionManager.getAttribute(CommonConstants.BUTTON_EL, "disabled", locator);
        Assert.assertEquals(buttonState, "disabled");
    }

    public static void validateToast(String message) {
        Assert.assertEquals(message, WebActionManager.getText(CommonConstants.TOAST_EL, message));
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
        System.out.println(concatString + randomString);

    }


}
