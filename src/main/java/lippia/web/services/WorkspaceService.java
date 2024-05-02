package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.WorkspaceConstants;
import org.testng.Assert;
import org.testng.Reporter;

public class WorkspaceService {
    public static void deployWorkspaceDropdown() throws InterruptedException {
        try {
            WebActionManager.click(WorkspaceConstants.WORKSPACE_DROPDOWN,false);
        } catch (Exception e) {
            Thread.sleep(500);
            WebActionManager.waitClickable(WorkspaceConstants.WORKSPACE_DROPDOWN).click();
            Reporter.log("Element needed explicit wait to be clickable. (Element click intercepted)");
        }
    }

    public static void deleteWorkspace() {
        if (WebActionManager.waitVisibility(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,"3").isDisplayed()){
        WebActionManager.click(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,false,"3");}
        else {
            Reporter.log("Workspace is either active or non-existent.");
        }
    }

    public static void typeDeleteOnInput() {
        WebActionManager.setInput(WorkspaceConstants.WORKSPACE_DELETE_INPUT,"DELETE");
    }

    public static void verifyIsOnWorkspaceSettings() {
        Assert.assertTrue(WebActionManager.isVisible(WorkspaceConstants.WORKSPACE_SETTINGS), "Element is not found in current view.");
    }
    public static void verifyListingPresence(){
        Assert.assertTrue(WebActionManager.isVisible(WorkspaceConstants.WORKSPACE_LISTING), "Element is not found in current view.");
    }
}
