@Regression @Timetracker
Feature: Timetracker

  Background:
    Given the user logs in to Clockify

  @SuccessfulTimetracker @Smoke
  Scenario Outline: Successful timetracker entry
    When the user types a <task>
    And the user types <time> as duration
    And the user clicks on the button with text " Add "
    Then the user can see the message "Time entry has been created"
    Examples:
      | task          | time     |
      | task_ | 01:00:00 |

  @SuccessfulTimetracker
  Scenario:  Successful time entry delete
    When the user deploys the dropdown on the selected entry
    And the user clicks on the link with text " Delete "
    And the user clicks on the button with text " Delete "
    Then the user can see the message "Time entry has been deleted"