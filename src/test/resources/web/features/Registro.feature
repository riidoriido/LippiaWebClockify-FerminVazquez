@Regression  @Registro
Feature: Registro

    Background:
        Given the user opens the browser and navigates to "https://clockify.me/"
        And the user clicks "link" "Sign Up Free"

    @SuccessfulRegister @Ignore
    Scenario: Successful registration
        When the user types "alguien@ejemplo.com"
        And the user clicks "termsOfUse"
        And the user clicks "button" "CONTINUE WITH EMAIL"
        And the user types the verification code
        Then the user is logged in to Clockify and can see the Timetracker

    @FailedRegister @Smoke
    Scenario: Failed register caused by missing ToS agreement
        When the user types "alguien@ejemplo.com"
        And the user tries clicking "continue with email"
        Then the app shows the message "You must accept the terms of service"
        And the button "continue with email" is not clickeable

    @FailedRegister @Ignore
    Scenario: Failed register caused by missing email
        When the user skips the email field
        And the user clicks "termsOfUse"
        Then the button "continue with email" is not clickeable

    @FailedRegister @Smoke
    Scenario: Failed register caused by invalid email
        When the user types "alguienejemplocom"
        Then the app shows the message "Email format is not valid"
        And el boton "continue with email" no es clickeable

    @SuccessfulRegister @Smoke
    Scenario: Register with Google
        When the user clicks "termsOfUse"
        And the user clicks "button" "Continue with google"
        And the user choses the account used to log in
        Then the user is logged in to Clockify and can see the Timetracker

