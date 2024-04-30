@Regression @Workspace
Feature: Workspace

    Background:
        Given the user logs in to Clockify
        And the user deploys the workspaces dropdown
        And the user clicks on the link with text " Manage "

    @WorkspaceSuccessful @Smoke
    Scenario: Successful workspace creation
        When the user clicks on the button with text " Create new "
        And the user types workspace_ on the input field
        And the user clicks on the button with text " Create "
        Then the user can see the message "Workspace has been created."

    @WorkspaceFailure @Smoke
    Scenario Outline: Workspace creation failure cause : <error>
        When the user clicks on the button with text " Create new "
        And the user types specifically a string with <char_length> characters
        Then the app shows the message " Workspace name has to be between 2 and 250 characters long "
        And the button " Create " is not clickeable

        Examples:
            | char_length |
            | 1           |
            | 252         |

    @WorkspaceSuccessful @Smoke
    Scenario: Delete workspace
        When the user clicks X button on Workspace
        And the user types the required DELETE keyword
        And the user clicks on the button with text " Delete Workspace "
        Then the user can see the message "You have left this workspace."

    @WorkspaceSuccessful @Ignore
    Scenario: Edit workspace
        When the user clicks on the button with text " Settings "
        And the user is on Workspace Settings
        When the user types "_edited" on field workspaceName
        Then the user can see the message "Workspace settings have been updated."


