Feature: Create Account on Automation Practice Landing Page

  Scenario: User creates a new account
    Given I am on the Automation Practice landing page
    When I navigate to create an account section
    And I enter valid email address "testjoe1120@example.com"
    And I click on the Create an account button
    Then I should see the Create an account form
    And I fill out the registration form with:
      | Title    | Mr  |
      | First Name | John  |
      | Last Name  | Doe  |
      | Password   | Password123  |
      | Date of Birth | 01/01/1990 |
    And I complete the registration
    Then I should be registered successfully and logged in

  Scenario: User attempts to create an account with an existing email
    Given I am on the Automation Practice landing page
    When I navigate to create an account section
    And I enter existing email address "test12@example.com"
    And I click on the Create an account button
    Then I should see an error message stating "An account using this email address has already been registered. Please enter a valid password or request a new one."

  Scenario: User attempts to create an account with invalid information
    Given I am on the Automation Practice landing page
    When I navigate to create an account section
    And I enter invalid email address "invalidemail"
    And I click on the Create an account button
    Then I should see an error message stating "Invalid email address."
  