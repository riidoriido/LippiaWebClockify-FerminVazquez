@Regression @Misc
Feature: Miscellaneous features

  Background:
    Given the user logs in to Clockify
    And the user sets the desired Workspace as active

  @Smoke @SetupEntriesForPDF
  Scenario: Export report to PDF
    When the user clicks the sidebar link "/reports/summary"
    And the user clicks on Range to open the Calendar
    And the user sets date June "3"
    And the user sets date June "9"
    And the user clicks on Export
    And the user clicks on Save as PDF
    Then the app shows a Loading popup and the file is downloaded

  @Smoke
  Scenario: Input data to create project, then cancel creation
    When the user clicks on the button with text " Create new "
    And the user types tpFinalProject_cancel on the project name input field
    And the user clicks on the link with text "Cancel"
    Then the user goes back to projects list and "tpFinalProject_cancel" is not visible

  @EditExistingTask @Smoke @revertChangesTimeEntry
  Scenario Outline: Edit existing created entry
    When the user types <task> over task description
    And the user clicks on the project picker
    And the user clicks on 'No project'
    And the user clicks on the $ icon
    And the user edits the <start> <end> range
    And the user selects new <date>
    Then the user can see the message "Successfully updated description."
    Examples:
      | task               | start | end | date |
      | editedTask_tpFinal | 12    | 19  | 6    |
