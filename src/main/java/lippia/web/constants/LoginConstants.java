package lippia.web.constants;

public class LoginConstants {

    public static final String LOGIN_BTN_BY_TEXT = "xpath://a[contains(.,'%s')]";
    public static final String LOGIN_FORM_TITLE = "xpath: //login";
    public static final String INPUT_EMAIL = "xpath: //input[@id='email' and @name='email']";
    public static final String INPUT_PASSWORD = "xpath: //input[@id='password' and @name='password']";
    public static final String BUTTON_LOGIN_XPATH = "xpath://button[@data-test-id='login-button']";
    public static final String LOGOUT_BUTTON_NEW = "xpath://a[@data-cy='logout']";
    public static final String MESSAGE_XPATH = "xpath://*[text()=%s]";
    public static final String USER_DROPDOWN = "xpath://a[@dropdownkeybutton and @class='cl-p-0 cl-dropdown-toggle cl-no-arrow cl-d-flex']";

}
