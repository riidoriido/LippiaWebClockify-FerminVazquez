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

    public static void typeNewWorkspaceName(String inputText) {
        String append = String.valueOf(Math.random()*10).replace(".","1");
        int maxLength = 5;
        String workspaceName = inputText + append.substring(0, Math.min(append.length(), maxLength));
        WebActionManager.waitPresence(WorkspaceConstants.WORKSPACE_NEW_INPUT);
        WebActionManager.setInput(WorkspaceConstants.WORKSPACE_NEW_INPUT,workspaceName);
    }
    public static void generateWorkspaceName(int char_length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < char_length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        String generatedString = String.valueOf(randomString);
        WebActionManager.setInput(WorkspaceConstants.WORKSPACE_NEW_INPUT,generatedString);
        //Error only shows when input is no longer on focus
        WebActionManager.click(WorkspaceConstants.WORKSPACE_NEW_INPUT_FOCUS_CLEAR);
    }

    public static void deleteWorkspace() {
        if (WebActionManager.getElement(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,"2").isDisplayed()){
        WebActionManager.click(WorkspaceConstants.DELETE_WORKSPACE_BUTTON,"2");}
        else {
            Reporter.log("Only active Workspace remains. Active Workspaces cannot be deleted.");
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
