@Regression  @Registro
Feature: Registro

  Background:
    Given the user opens the browser and navigates to Clockify homepage
    And the user clicks on the link with text "Sign up free"

  @FailedRegister @Smoke
  Scenario: Failed register caused by missing ToS agreement
    When the user types test@user.com for email
    And the user "unchecks" the ToS agreement
    Then the app shows the message " You must accept the terms of service "
    And the button " Continue with email " is not clickeable

  @FailedRegister @Smoke
  Scenario: Failed register caused by missing email
    When the user leaves an empty email field
    And the user "checks" the ToS agreement
    Then the button " Continue with email " is not clickeable

  @FailedRegister
  Scenario: Failed register caused by invalid email
    When the user types "alguienejemplocom" on field email
    Then the app shows the message "Email format is not valid "
    And the button " Continue with email " is not clickeable


