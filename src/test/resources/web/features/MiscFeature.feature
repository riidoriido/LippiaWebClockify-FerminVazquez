Feature: Miscellaneous features

  Background:
    Given the user logs in to Clockify
    And the user sets the desired Workspace as active

    @PDF
  Scenario: Export report to PDF
    And the user clicks the sidebar link "/reports/summary"
    And the user clicks on Range to open the Calendar
    And the user sets date June "3"
    And the user sets date June "9"
    And the user clicks on Export
    When the user clicks on Save as PDF
    Then the app shows a Loading popup and the file is downloaded
