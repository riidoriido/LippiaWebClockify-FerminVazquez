package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.CommonService;

public class CommonSteps extends PageSteps {


    @Given("the user opens the browser and navigates to Clockify homepage$")
    public void theUserOpensTheBrowserAndNavigatesTo() {
        CommonService.navigateToClockify();
    }

    @When("the user is logged in to Clockify")
    public void theUserIsLoggedInToClockify() {
        CommonService.loginToClockify();
    }

    @And("the user clicks on the button with text (.*)$")
    public static void userClicksButton(String targetText) {
        CommonService.clickButton(targetText);
    }

    @And("the user clicks on the link with text (.*)$")
    public static void userClicksLink(String targetText) {
        CommonService.clickLink(targetText);
    }

    @When("the user types on field (.*)$")
    public void typeForLogin(String locator) {
        CommonService.loginDataFull(locator);
    }

    @Then("the user can see the message (.*)$")
    public void theUserCanSeeTheMessage(String message) {
        CommonService.validateToast(message);
    }


    @And("the button (.*) is not clickeable$")
    public void theButtonIsNotClickeable(String locator) {
        CommonService.buttonNotClickeable(locator);
    }

    @And("the user types (.*) on field (.*)$")
    public void theUserTypesValueOnField(String inputText, String locator) {
        CommonService.inputText(inputText, locator);
    }

    @Then("the user is logged in to Clockify and can see the Timetracker")
    public void theUserIsLoggedInToClockifyAndCanSeeTheTimetracker() {
        CommonService.verifyLoggedIn();
    }


}
