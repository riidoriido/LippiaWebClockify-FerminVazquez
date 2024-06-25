package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.CommonConstants;
import lippia.web.constants.MiscConstants;
import lippia.web.constants.WorkspaceConstants;
import org.openqa.selenium.By;
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
        if (WebActionManager.waitVisibility(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,"3").isDisplayed()){
        WebActionManager.click(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,false,"3");}
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

    public static void resetWorkspaceCreated() throws InterruptedException {
        CommonService.changeWorkspace();
        WebActionManager.waitInvisibility(CommonConstants.TOAST_EL);
        WebActionManager.click(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,true,"10");
        typeDeleteOnInput();
        CommonService.clickButton("' Delete Workspace '");


    }
}
