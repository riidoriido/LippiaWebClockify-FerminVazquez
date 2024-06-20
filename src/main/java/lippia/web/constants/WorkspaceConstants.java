package lippia.web.constants;

public class WorkspaceConstants {
public static final String WORKSPACE_DROPDOWN = "xpath://app-workspace-picker/div[@class='cl-d-none cl-d-lg-inline-flex cl-cut-text-wrapper cl-mr-3']";
public static final String WORKSPACE_SETTINGS = "xpath://h1[text()='Workspace settings']";
public static final String WORKSPACE_LISTING = "xpath://span[text()='Workspaces']";
public static final String WORKSPACE_NEW_INPUT = "xpath://create-workspace-modal//input[@formControlName='name']";
public static final String WORKSPACE_NEW_INPUT_FOCUS_CLEAR = "xpath://create-workspace-modal";
public static final String DELETE_WORKSPACE_BUTTON = "xpath://workspace-row[%s]//div[2]/button";
public static final String WORKSPACE_DELETE_INPUT = "xpath://delete-workspace-modal/form/div/div/input";
public static final String DOTTED_WORKSPACE_SETTINGS_DEPLOY = "xpath://img[@alt='Workspace dropdown options']";
public static final String DROPDOWN_TOPBAR_MANAGE_WORKSPACES = "xpath://*[@id='topbar-menu']/div/div[1]/div[3]/app-topbar-options/div/div/div/a[2]";
public static final String LAST_WORKSPACE_IN_LIST = "xpath://workspace-row[last()]//button[text()=' Settings ']";
public static final String ACTIVE_WORKSPACE_TEXT = "xpath://*[@id='topbar-menu']//p";

}
