@Regression @Timetracker
Feature: Timetracker

  Background:
    Given the user logs in to Clockify

  @Smoke
  Scenario Outline: Successful timetracker entry
    When the user types a <task>
    And the user completes the <start> <end> range
    And the user selects desired <date>
    And the user clicks on the button with text " Add "
    Then the user can see the message "Time entry has been created"
    Examples:
      | task  | date | start | end  |
      | task_ | 9    | 8  | 16 |


  @Smoke
  Scenario:  Successful time entry delete
    When the user deploys the dropdown on the selected entry
    And the user clicks on the link with text " Delete "
    And the user clicks on the button with text " Delete "
    Then the user can see the message "Time entry has been deleted"
