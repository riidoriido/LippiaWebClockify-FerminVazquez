package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.RegisterConstants;

public class RegisterService {

    public static void inputEmailRegister(String inputText) {
        WebActionManager.setInput(RegisterConstants.EMAIL_REGISTER, inputText, true, false);
    }

    public static void termsOfUseManage(String state) {
        if (state.equals("unchecks")) {
            WebActionManager.click(RegisterConstants.TOS_CHECKBOX);
            WebActionManager.click(RegisterConstants.TOS_CHECKBOX);
        } else if (state.equals("checks")) {
            WebActionManager.click(RegisterConstants.TOS_CHECKBOX);
        }

    }

    public static void emptyInputEmail() {
        WebActionManager.setInput(RegisterConstants.EMAIL_REGISTER, "", true);
    }
}
