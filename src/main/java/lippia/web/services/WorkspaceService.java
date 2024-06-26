package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.WorkspaceConstants;
import org.testng.Assert;
import org.testng.Reporter;

public class WorkspaceService {
    public static void deployWorkspaceDropdown(){
            WebActionManager.waitClickable(WorkspaceConstants.WORKSPACE_DROPDOWN).click();
    }

    public static void manageWorkspaces() {
        WebActionManager.waitVisibility(WorkspaceConstants.DROPDOWN_TOPBAR_MANAGE_WORKSPACES).click();
    }

    public static void deleteWorkspace() {
        if (WebActionManager.waitVisibility(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,"10").isDisplayed()){
        WebActionManager.click(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,true,"10");}
        else {
            Reporter.log("Workspace is either active or non-existent.");
        }
    }

    public static void typeDeleteOnInput() {
        WebActionManager.setInput(WorkspaceConstants.WORKSPACE_DELETE_INPUT,"DELETE");
    }

    public static void returnToWorkspaceList(){
        DriverManager.getDriverInstance().navigate().back();
        Assert.assertTrue(WebActionManager.isVisible(WorkspaceConstants.WORKSPACE_LISTING), "Element is not found in current view.");
    }

}
