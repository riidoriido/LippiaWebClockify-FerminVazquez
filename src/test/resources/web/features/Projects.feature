@Regression @Projects
Feature: Projects

  Background:
    Given the user logs in to Clockify
    And the user sets the desired Workspace as active
    And the user clicks the sidebar link "/projects"


  @SuccessfulProjects @Smoke @setupProjectCreation
  Scenario: Successful project creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinalProject on the project name input field
    And the user clicks on the button with text " Create "
    Then the user can see the message " Project has been created "

  @FailureProjects @Smoke
  Scenario: Failed project creation (String does not meet requirements)
    When the user clicks on the button with text " Create new "
    And the user types specifically a project name with 255 characters
    And the user clicks on the button with text " Create "
    Then the user can see the message " Project name has to be between 2 and 250 characters long "


