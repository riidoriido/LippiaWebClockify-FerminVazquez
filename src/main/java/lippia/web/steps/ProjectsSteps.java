package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import lippia.web.services.ApiHelperService;
import lippia.web.services.CommonService;

public class ProjectsSteps extends PageSteps {

    @Before
    public void setupProjects(){
        ApiHelperService.checkForWorkspace();
        ApiHelperService.checkForProject();
    }

    @And("the user sets the desired Workspace as active")
    public void theUserSetsTheDesiredWorkspaceAsActive() {
        CommonService.changeWorkspace();
    }
    @And("the user types (.*) on the (.*) name input field$")
    public void userTypesProjectsName(String inputText, String locator){
        CommonService.typeNewName(inputText, locator);

    }

    @After
    public void cleanUpProject() {
        ApiHelperService.checkForProject();
    }


}
