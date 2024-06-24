Feature: Sign-in and Sign-out on Automation Practice Website
@Regression
  Scenario: Successful sign-in with valid credentials
    Given I am on the Automation Practice landing page
    When I sign in with "testjoe2@example.com" and "Password123"
    Then I should be logged in successfully
@Smoke
  Scenario: Unsuccessful sign-in with invalid credentials
    Given I am on the Automation Practice landing page
    When I sign in with "test12@example.com" and "Password1234"
    Then I should see an error message as "Authentication failed."
@Smoke
  Scenario: Unsuccessful sign-in with another set of invalid credentials
    Given I am on the Automation Practice landing page
    When I sign in with "newuser@example.com" and "Password12345"
    Then I should see an error message as "Authentication failed."
@Regression
  Scenario: User signs out from the account
    Given I am logged in on the Automation Practice website
    When I sign out from the account
    Then I should be logged out successfully
