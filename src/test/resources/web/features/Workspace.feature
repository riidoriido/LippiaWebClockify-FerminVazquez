@Regression @Workspace
Feature: Workspace

    Background:
        Given the user performs a successful login in Clockify App
        And the user deploys the workspaces dropdown
        And the user clicks "button" "Manage"

    @WorkspaceSuccessful @Smoke
    Scenario: Successful workspace creation
        When the user clicks "button" "Create new Workspace"
        And the user types "workspace_"
        And the user clicks "button" "Create"
        Then the user can see the message "Workspace has been created"

    @WorkspaceFailure @Smoke
    Scenario Outline: Workspace creation failure cause : <error>
        When the user clicks "button" "Create new Workspace"
        And the user types <char_length>
        Then the app shows the message <error>
        And the button "Create" is not clickeable

        Examples:
            | char_length | error|
            | 2           |   Workspace name has to be between 2 and 250 characters long   |
            | 255         |      |

    @WorkspaceSuccessful @Smoke
    Scenario: Delete workspace
        When the user clicks "button" "DELETE"
        And the user types "DELETE"
        And the user clicks "button" "DELETE WORKSPACE"
        Then the user can see the message "You have left this workspace"

    @WorkspaceSuccessful @Smoke
    Scenario: Edit workspace
        When the user clicks "button" "SETTINGS"
        And the user is on Workspace Settings
        When the user types "_edited"
        Then the user can see the message "Workspace settings have been updated"

    @WorkspaceSuccessful @Smoke
    Scenario: Change workspace to active
        When the user clicks "button" "SETTINGS"
        And the user returns returns to the listing
        Then the user can see the message "Workspace has been created"


