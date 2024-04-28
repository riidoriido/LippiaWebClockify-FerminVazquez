@Regression @Login
Feature: Login

  Background:
    Given the user opens the browser and navigates to Clockify homepage
    And the user clicks on the link with text "Log in"

  @SuccessLogin @Smoke
  Scenario: Successful Log in with email
    When the user types on field email
    And the user clicks on the button with text " Continue with email "
    Then the user is logged in to Clockify and can see the Timetracker

  @SuccessLogin @Smoke
  Scenario: Successful manual Log in
    When the user clicks on the link with text " Log in manually "
    And the user types on field email
    And the user types on field password
    And the user clicks on the button with text " Log In "
    Then the user is logged in to Clockify and can see the Timetracker

  @FailedLogin @Smoke
  Scenario Outline: Failed log in cause: <error>
    When the user clicks on the link with text " Log in manually "
    And the user types <email> on field "email"
    And the user types <password> on field "password"
    And the user clicks the Log In button
    Then the app shows the message <error>

    Examples:
      | email               | password | error                        |
      | user@ejemplo.com | 123456   | "Invalid email or password"  |
      | alguienejemplocom   | 123456   | "Email format is not valid " |

  @FailedLogin @Smoke
  Scenario: Failed login caused by invalid email
    When the user types "alguienejemplocom" on field "email"
    Then the app shows the message "Email format is not valid"
    And the button "continue with email" is not clickeable

  @Logout @Smoke @loginTest
  Scenario: Successful logout
    When the user is logged in to Clockify
    And the user deploys the user dropdown
    And the user clicks on the link with text " Log out "
    Then the user returns to the login screen