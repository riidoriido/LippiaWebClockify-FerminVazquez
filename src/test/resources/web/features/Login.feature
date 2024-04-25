@Regression @Login
Feature: Login
    Background:
        Given the user opens the browser and navigates to the Clockify app
        And the user clicks "Log in"

    @SuccessLogin @Smoke
    Scenario: Successful Log in with email
        When the user types "fervazquez.dev@gmail.com"
        And the user clicks "CONTINUE WITH MAIL"
        Then the user is logged in to Clockify and can see the Timetracker

    @SuccessLogin @Ignore
    Scenario: Successful Log in with Google
        When the user clicks "CONTINUE WITH GOOGLE"
        And the user choses the account used to log in
        Then the user is logged in to Clockify and can see the Timetracker

    @SuccessLogin @Smoke
    Scenario Outline: Successful manual Log in
        When the user clicks <manual_link>
        And the user types <email>
        And the user types <password>
        And the user clicks <login>
        Then the user is logged in to Clockify and can see the Timetracker

        Examples:
            | email                    | password     | login  | manual_link     |
            | fervazquez.dev@gmail.com | _clockify123 | LOG IN | Log In manually |

    @FailedLogin @Smoke
    Scenario Outline: Failed log in cause: <error>
        When the user clicks <manual_link>
        And the user types <email>
        And the user types <password>
        Then the app shows the message <error>
        And the button "log in" is not clickeable

        Examples:
            | email               | password | error                     | manual_link     |
            |                     | 123456   | Email is required         | Log in manually |
            | alguien@ejemplo.com | 123456   | Invalid email or password |                 |
            | alguienejemplocom   | 123456   | Email format is not valid |                 |

    @FailedLogin @Smoke
    Scenario: Failed login caused by invalid email
        When the user types "alguienejemplocom"
        Then the app shows the message "Email format is not valid"
        And the button "continue with email" is not clickeable

    @FailedLogin
    Scenario: Failed log in caused by missing email
        When the user deletes previously typed email
        Then the app shows the message "Email is required"
        And the button "continue with email" is not clickeable

    @Logout @Smoke
    Scenario: Successful logout
        When the user is logged in to Clockify and can see the Timetracker
        And the user clicks the user dropdown
        And the user clicks "logout"
        Then the user returns to the login screen