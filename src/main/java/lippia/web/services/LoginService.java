package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LoginConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginService extends ActionManager {

    public static void userClicksLoginButton() {
        WebElement button = WebActionManager.getElement(LoginConstants.BUTTON_LOGIN_XPATH);
        if (button.isEnabled()){
            WebActionManager.click(LoginConstants.BUTTON_LOGIN_XPATH);
        } else  {
            System.out.println("Button is disabled: requirements not met.");
        }
    }
    public static void validateLoginError(String errorMsg) {
        WebActionManager.waitVisibility(LoginConstants.MESSAGE_XPATH,errorMsg);
        String actualMsg = WebActionManager.getText(LoginConstants.MESSAGE_XPATH,errorMsg);
        Assert.assertTrue(errorMsg.contains(actualMsg),"String mismatch.");
    }

    public static void deployUserDropDown() {
        WebActionManager.click(LoginConstants.USER_DROPDOWN,false);
    }
    public static void isOnLoginScreen() {
        WebActionManager.waitVisibility(LoginConstants.LOGIN_FORM_TITLE);
        Assert.assertTrue(WebActionManager.isVisible(LoginConstants.LOGIN_FORM_TITLE),"Login screen not visible.");

    }
}
