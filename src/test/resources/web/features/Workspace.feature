@Regression @Workspace
Feature: Workspace

  Background:
    Given the user logs in to Clockify
    And the user deploys the workspaces dropdown
    And the user clicks on Manage Workspaces

  @WorkspaceSuccessfulCreation @Smoke
  Scenario: Successful workspace creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinal_AAT_2 on the workspace name input field
    And the user clicks on the button with text " Create "
    Then the user can see the message "Workspace has been created."

  @WorkspaceFailureCreation
  Scenario: Workspace creation failure cause : <error>
    When the user clicks on the button with text " Create new "
    And the user types specifically a workspace name with 55 characters
    Then the app shows the message  " Workspace name has to be between 1 and 50 characters long "
    And the button " Create " is not clickeable

  @WorkspaceSuccessfulEdit @Smoke
  Scenario: Edit workspace
    And the user clicks on the button with text " Settings "
    When the user types _edited on field "workspaceName"
    And the user returns to the listing
    Then the user can see the message "Workspace settings have been updated."

  @WorkspaceSuccessfulDelete @Smoke
  Scenario: Delete workspace
    When the user clicks X button on Workspace
    And the user types the required DELETE keyword
    And the user clicks on the button with text " Delete Workspace "
    Then the user can see the message "You have left this workspace."


