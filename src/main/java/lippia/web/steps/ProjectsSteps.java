package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.*;
import lippia.web.services.ApiHelperService;
import lippia.web.services.CommonService;
import lippia.web.services.MiscService;

public class ProjectsSteps extends PageSteps {

    @And("check for required preconditions")
    public void checkForRequiredPreconditions() {
        ApiHelperService.checkForWorkspace();
        ApiHelperService.checkForProjectAndDelete();
    }

    @And("the user sets the desired Workspace as active")
    public void theUserSetsTheDesiredWorkspaceAsActive() throws InterruptedException {
        CommonService.changeWorkspace();
    }

    @And("the user types (.*) on the (.*) name input field$")
    public void userTypesProjectsName(String inputText, String locator) {
        CommonService.typeNewName(inputText, locator);
    }

    @Then("the user goes back to projects list and {string} is not visible")
    public void theUserGoesBackToProjectsListAndIsNotVisible(String projectName) {
        MiscService.verifyProjectNotCreated(projectName);
    }

    @And("cleanup service is executed")
    public void cleanupServiceIsExecuted() {
        ApiHelperService.checkForProjectAndDelete();
    }


}
