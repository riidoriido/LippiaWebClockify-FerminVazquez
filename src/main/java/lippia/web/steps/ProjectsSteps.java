package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import lippia.web.services.ApiHelperService;
import lippia.web.services.CommonService;
import lippia.web.services.MiscService;

public class ProjectsSteps extends PageSteps {

//    @BeforeStep
//    public void setupProjects(){
//        ApiHelperService.checkForWorkspace();
//        ApiHelperService.checkForProject();
//    }

    @And("the user sets the desired Workspace as active")
    public void theUserSetsTheDesiredWorkspaceAsActive() throws InterruptedException {
        CommonService.changeWorkspace();
    }
    @And("the user types (.*) on the (.*) name input field$")
    public void userTypesProjectsName(String inputText, String locator){
        CommonService.typeNewName(inputText, locator);

    }
    @Then("the user goes back to projects list and {string} is not visible")
    public void theUserGoesBackToProjectsListAndIsNotVisible(String projectName) {
        MiscService.verifyProjectNotCreated(projectName);
    }
//    @AfterStep
//    public void cleanUpProject() {
//        ApiHelperService.checkForProject();
//    }



}
