Feature: new user sign up

  Scenario: An unauthorized user experiences Sign Up process
    Given an unauthorized user has landed on the "EasyChamp" main page
    And navigates to sign up page
    When enters signup information
    And submits the form
    Then sees that confirmation email were sent
    And should receive a confirmation email
    Then opens activation link in the browser
    And fills out confirmation form