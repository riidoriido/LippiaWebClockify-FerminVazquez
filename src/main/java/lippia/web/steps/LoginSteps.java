package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.LoginService;

public class LoginSteps extends PageSteps {
    @Then("the app shows the message (.*)$")
    public void theAppShowsTheMessage(String errorMsg) {
        LoginService.validateLoginError(errorMsg);
    }

    @And("the user clicks the Log In button$")
    public void theUserClicksTheLogInButton() {
        LoginService.userClicksLoginButton();
    }

    @And("the user deploys the user dropdown$")
    public void theUserDeploysTheUserDropdown() {
        LoginService.deployUserDropDown();
    }

    @And("the user clicks on Log out link")
    public void theUserClicksOnLogOutLink() {
        LoginService.clickOnLogout();
    }

    @Then("the user returns to the login screen$")
    public void theUserReturnsToTheLoginScreen() {
        LoginService.isOnLoginScreen();
    }


}
