package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.CommonConstants;
import lippia.web.constants.LoginConstants;
import org.testng.Assert;
import org.testng.Reporter;


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
        } catch (Exception e) {
            Reporter.log("Unable to get credentials. Check sysEnv.");
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


        } catch (Exception e) {
            Reporter.log("Unable to get credentials. Check sysEnv.");
        }
        WebActionManager.click(LoginConstants.BUTTON_LOGIN_XPATH);
    }

    public static void autoLogin() {
        navigateToClockify();
        WebActionManager.click(CommonConstants.LINK_EL,"'Log in'");
        loginToClockify();
    }

    public static void verifyLoggedIn() {
        WebActionManager.waitVisibility(CommonConstants.TRACKER_TAB);
        Assert.assertTrue(WebActionManager.isVisible(CommonConstants.TRACKER_TAB),"User is either offline or element is not present.");
    }

    public static void clickButton(String targetText) {
        WebActionManager.waitClickable(CommonConstants.BUTTON_EL,targetText);
        WebActionManager.click(CommonConstants.BUTTON_EL,false, targetText);
    }

    public static void clickLink(String targetText) {
        WebActionManager.waitClickable(CommonConstants.LINK_EL,targetText);
        WebActionManager.click(CommonConstants.LINK_EL,false, targetText);
    }

    public static void inputText(String inputText, String locator) {
        WebActionManager.setInput(CommonConstants.INPUT_EL, inputText, true, false, locator);
    }

    public static void buttonNotClickeable(String locator) {
        String buttonState = WebActionManager.getAttribute(CommonConstants.BUTTON_EL, "disabled", locator);
        Assert.assertTrue(Boolean.parseBoolean(buttonState), "Button is enabled.");
    }

    public static void validateToast(String message) {
        Assert.assertTrue(WebActionManager.waitVisibility(CommonConstants.TOAST_EL).isDisplayed(), "Element is not visible in current view.");
        Reporter.log("Reporter message: " + message);
    }


}
