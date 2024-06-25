package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.CommonService;
import lippia.web.services.WorkspaceService;

public class WorkspaceSteps extends PageSteps {
    @And("the user deploys the workspaces dropdown$")
    public void userDeploysWorkspaceDropdown() {
        WorkspaceService.deployWorkspaceDropdown();
    }

    @And("the user clicks on Manage Workspaces")
    public void theUserClicksOnManageWorkspaces() {
        WorkspaceService.manageWorkspaces();
    }

    @And("the user types specifically a (.*) name with (.*) characters$")
    public void userTypesIntCharString(String locator, int char_length) {
        CommonService.generateNameError(locator, char_length);
    }

    @And("the user returns to the listing$")
    public void theUserReturnsReturnsToTheListing() {
        WorkspaceService.returnToWorkspaceList();
    }

    @And("the user types the required DELETE keyword$")
    public void theUserTypesTheRequiredDELETEKeyword() {
        WorkspaceService.typeDeleteOnInput();
    }

    @When("the user clicks X button on Workspace$")
    public void theUserClicksXButtonOnWorkspace() {
        WorkspaceService.deleteWorkspace();
    }

    @And("rollback workspace creation")
    public void rollbackWorkspaceCreation() throws InterruptedException {
        WorkspaceService.resetWorkspaceCreated();
    }
}
