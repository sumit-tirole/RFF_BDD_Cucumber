Feature: Login feature

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username
    And user enters password
    And user clicks on Login button
    Then verify the page title
    And user clicks on account button
    Then user clicks on logout button



