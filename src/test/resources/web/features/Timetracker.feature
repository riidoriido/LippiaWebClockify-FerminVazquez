@Regression @Timetracker
Feature: Timetracker

  Background:
    Given the user performs a successful login in Clockify App

  @SuccessfulTimetracker @Smoke
  Scenario Outline: Successful timetracker entry
    When the user types <task>
    And the user clicks "Project"
    And the user types <time>
    And the user clicks "ADD"
    Then the user can see the message "Time entry has been created"
    Examples:
      | task          | time     |
      | example_task_ | 01:00:00 |

  @SuccessfulTimetracker @Smoke
  Scenario:  Successful time entry delete
    When the user clicks the dropdown on the selected entry
    And the user clicks "delete"
    And the user click "DELETE"
    Then the user can see the message "Time entry has been deleted"