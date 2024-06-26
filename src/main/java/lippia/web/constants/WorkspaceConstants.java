package lippia.web.constants;

public class WorkspaceConstants {
    public static final String WORKSPACE_DROPDOWN = "xpath://app-topbar-options";
    public static final String WORKSPACE_LISTING = "xpath://span[text()='Workspaces']";
    public static final String WORKSPACE_NEW_INPUT = "xpath://create-workspace-modal//input[@formControlName='name']";
    public static final String WORKSPACE_NEW_INPUT_FOCUS_CLEAR = "xpath://create-workspace-modal";
    public static final String DELETE_WORKSPACE_BUTTON = "xpath://workspace-row[%s]//img[@data-cy='delete-workspace']";
    public static final String WORKSPACE_DELETE_INPUT = "xpath://delete-workspace-modal/form/div/div/input";
    public static final String DROPDOWN_TOPBAR_MANAGE_WORKSPACES = "xpath://*[@id='topbar-menu']/div/div[1]/div[3]/app-topbar-options/div/div/div/a[2]";
    public static final String PRIORITY_WORKSPACE_IN_LIST = "xpath://workspace-row[8]//button[text()=' Settings ']";
    public static final String ACTIVE_WORKSPACE_TEXT = "xpath://app-top-bar/div/div/div[1]/div[3]/div/p";

}
