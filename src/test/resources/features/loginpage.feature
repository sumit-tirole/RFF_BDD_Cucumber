Feature: Login feature

  Scenario Outline: Login with correct credentials
    Given user is on login page
    When user enters username <username>
    And user enters password <password>
    And user clicks on Login button
    Then page title should be <PageTitle>
    And user clicks on account button
    Then user clicks on logout button
    Examples:
      | username                 | password       |  | PageTitle                                                                     |
      | "strokenavior@gmail.com" | "Password@123" |  | "Easily Find Reward Flight Availability: Redeem British Airways Avios Points" |


