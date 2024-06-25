@Regression @Projects
Feature: Projects

  Background:
    Given the user logs in to Clockify
    And check for required preconditions
    And the user sets the desired Workspace as active
    And the user clicks the sidebar link "/projects"


  @SuccessfulProjects @Smoke
  Scenario: Successful project creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinalProject on the project name input field
    And the user clicks on the button with text " Create "
    Then the user can see the message " Project has been created "
    And cleanup service is executed

  @SuccessfulProjects @Smoke
  Scenario: Input data to create project, then cancel creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinalProject_cancel on the project name input field
    And the user clicks on the link with text "Cancel"
    Then the user goes back to projects list and "tpFinalProject_cancel" is not visible

  @FailureProjects @Smoke
  Scenario: Failed project creation (String does not meet requirements)
    When the user clicks on the button with text " Create new "
    And the user types specifically a project name with 255 characters
    And the user clicks on the button with text " Create "
    Then the user can see the message " Project name has to be between 2 and 250 characters long "


