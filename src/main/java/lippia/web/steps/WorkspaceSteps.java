package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.WorkspaceService;

public class WorkspaceSteps extends PageSteps {
    @And("the user deploys the workspaces dropdown$")
    public void userDeploysWorkspaceDropdown() throws InterruptedException {
        WorkspaceService.deployWorkspaceDropdown();
    }

    @And("the user is on Workspace Settings$")
    public void theUserIsOnWorkspaceSettings() {
        WorkspaceService.verifyIsOnWorkspaceSettings();

    }
    @And("the user types (.*) on the input field$")
    public void userTypesWorkspaceName(String inputText){
        WorkspaceService.typeNewWorkspaceName(inputText);

    }
    @And("the user types specifically a string with (.*) characters$")
    public void userTypesIntCharString(int char_length){
        WorkspaceService.generateWorkspaceName(char_length);
    }

    @And("the user returns returns to the listing$")
    public void theUserReturnsReturnsToTheListing() {
        WorkspaceService.verifyListingPresence();
    }

    @And("the user types the required DELETE keyword$")
    public void theUserTypesTheRequiredDELETEKeyword() {
        WorkspaceService.typeDeleteOnInput();
    }

    @When("the user clicks X button on Workspace$")
    public void theUserClicksXButtonOnWorkspace() {
        WorkspaceService.deleteWorkspace();
    }
}
