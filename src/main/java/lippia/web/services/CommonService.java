package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.*;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;


public class CommonService {

    public static void navigateToClockify() {
        WebActionManager.navigateTo("https://clockify.me");
    }

    public static String[] getAuthCred() {
        String[] credentials = new String[2];
        try {
            String userEnv = PropertyManager.getProperty("clockify.id");
            String passwordEnv = PropertyManager.getProperty("clockify.auth");
            credentials[0] = userEnv;
            credentials[1] = passwordEnv;

        } catch (Exception e) {
            Reporter.log("Unable to get credentials. Check sysEnv.");
        }

        return credentials;
    }

    public static void loginDataFull(String locator) {
        String[] credentials = getAuthCred();
        switch (locator) {
            case "email":
                WebActionManager.waitVisibility(LoginConstants.INPUT_EMAIL);
                WebActionManager.setInput(LoginConstants.INPUT_EMAIL, String.valueOf(credentials[0]));
                break;
            case "password":
                WebActionManager.waitVisibility(LoginConstants.INPUT_PASSWORD);
                WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, String.valueOf(credentials[1]));
                break;
        }
    }

    public static void loginToClockify() {
        String[] credentials = getAuthCred();
        WebActionManager.click(LoginConstants.LOGIN_BTN_BY_TEXT, " Log in manually ");
        WebActionManager.setInput(LoginConstants.INPUT_EMAIL, String.valueOf(credentials[0]));
        WebActionManager.setInput(LoginConstants.INPUT_PASSWORD, String.valueOf(credentials[1]));
        WebActionManager.click(LoginConstants.BUTTON_LOGIN_XPATH);
    }

    public static void fullLogin() {
        WebActionManager.navigateTo("https://app.clockify.me/en/login");
        loginToClockify();
    }

    public static void verifyLoggedIn() {
        WebActionManager.waitVisibility(CommonConstants.TRACKER_TAB);
        Assert.assertTrue(WebActionManager.isVisible(CommonConstants.TRACKER_TAB), "User is either offline or element is not present.");
    }

    public static void clickButton(String targetText) {
        WebActionManager.waitClickable(CommonConstants.BUTTON_EL, targetText);
        WebActionManager.click(CommonConstants.BUTTON_EL, false, targetText);
    }

    public static void clickSidebar(String targetText) {
        WebActionManager.waitClickable(CommonConstants.SIDEBAR_MANAGE, targetText).click();
    }

    public static void clickLink(String targetText) {
        WebActionManager.waitClickable(CommonConstants.LINK_EL, targetText);
        WebActionManager.click(CommonConstants.LINK_EL, false, targetText);
    }

    public static void inputText(String inputText, String locator) {
        if (locator.equals("email")) {
            WebActionManager.setInput(CommonConstants.INPUT_EL, inputText, true, locator);
            WebActionManager.click(CommonConstants.INPUT_EL, locator);

        } else {
            WebActionManager.setInput(CommonConstants.INPUT_EL, inputText + generateRandomString(5), true, locator);
        }
    }

    public static void buttonNotClickeable(String locator) {
        String buttonState = WebActionManager.getAttribute(CommonConstants.BUTTON_EL, "disabled", locator);
        Assert.assertTrue(Boolean.parseBoolean(buttonState), "Button is enabled.");
    }

    public static void validateToast(String message) {
        Assert.assertTrue(WebActionManager.waitVisibility(CommonConstants.TOAST_EL).isDisplayed(), "Element is not visible in current view.");
        Reporter.log("Reporter message: " + message);
    }

    public static String generateRandomString(int char_length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < char_length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        return String.valueOf(randomString);
    }

    public static void typeNewName(String inputText, String locator) {
        switch (locator) {
            case "project":
                WebActionManager.setInput(MiscConstants.PROJECT_NEW_INPUT, inputText, true, false);
                break;
            case "workspace":
                WebActionManager.setInput(WorkspaceConstants.WORKSPACE_NEW_INPUT, inputText, true, false);
                break;
            default:
                System.out.println(locator + " is not a valid case.");
        }
    }

    public static void generateNameError(String locator, int char_length) {
        switch (locator) {
            case "project":
                WebActionManager.setInput(MiscConstants.PROJECT_NEW_INPUT, "project" + CommonService.generateRandomString(char_length), true, false);
                break;
            case "workspace":
                WebActionManager.waitVisibility(WorkspaceConstants.WORKSPACE_NEW_INPUT);
                WebActionManager.setInput(WorkspaceConstants.WORKSPACE_NEW_INPUT, "workspace" + CommonService.generateRandomString(char_length), true, false);
                //Error only shows when input is no longer on focus
                WebActionManager.click(WorkspaceConstants.WORKSPACE_NEW_INPUT_FOCUS_CLEAR);
                break;
            default:
                System.out.println(locator + " is not a valid case.");
        }
    }

    public static void changeWorkspace() throws InterruptedException {
        String activeWorkspace = WebActionManager.getText(WorkspaceConstants.ACTIVE_WORKSPACE_TEXT);
        if (!activeWorkspace.equals("tpFinal_AAT")) {
            WorkspaceService.deployWorkspaceDropdown();
            WebActionManager.waitClickable(WorkspaceConstants.DROPDOWN_TOPBAR_MANAGE_WORKSPACES).click();
            WebActionManager.click(WorkspaceConstants.LAST_WORKSPACE_IN_LIST);
            DriverManager.getDriverInstance().navigate().back();
        }
    }

    public static String parseListToString(List<String> list) {
        return String.join(",", list);
    }

}
