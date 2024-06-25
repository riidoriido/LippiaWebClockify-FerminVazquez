@Regression @Misc
Feature: Miscellaneous features

  Background:
    Given the user logs in to Clockify
    And the user sets the desired Workspace as active

  @Smoke
  Scenario: Export report to PDF
    And create entries by api
    And the user clicks the sidebar link "/reports/summary"
    And the user clicks on Range to open the Calendar
    And the user sets date June "3"
    And the user sets date June "9"
    And the user clicks on Export
    When the user clicks on Save as PDF
    Then the app shows a Loading popup and the file is downloaded
    And created entries are deleted by api

  @Smoke
  Scenario: Input data to create project, then cancel creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinalProject_cancel on the project name input field
    And the user clicks on the link with text "Cancel"
    Then the user goes back to projects list and "tpFinalProject_cancel" is not visible