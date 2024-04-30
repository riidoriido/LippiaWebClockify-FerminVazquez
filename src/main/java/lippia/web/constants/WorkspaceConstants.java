package lippia.web.constants;

public class WorkspaceConstants {
public static final String WORKSPACE_DROPDOWN = "xpath://app-workspace-picker/div[@class='cl-d-none cl-d-lg-inline-flex cl-cut-text-wrapper cl-mr-3']";
public static final String WORKSPACE_SETTINGS = "xpath://h1[text()='Workspace settings']";
public static final String WORKSPACE_LISTING = "xpath://span[text()='Workspaces']";
public static final String WORKSPACE_NEW_INPUT = "xpath: //create-workspace-modal/form/div[1]/div/div/input[@ngbautofocus]";
public static final String WORKSPACE_NEW_INPUT_FOCUS_CLEAR = "xpath: //create-workspace-modal";
public static final String DELETE_WORKSPACE_BUTTON = "xpath: //workspace-row[%s]//button/img[@data-cy='delete-workspace']";
public static final String WORKSPACE_DELETE_INPUT = "xpath: //delete-workspace-modal/form/div/div/input";

}
