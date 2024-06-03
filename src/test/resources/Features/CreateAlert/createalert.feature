Feature: Alert Management

  Scenario: Create Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When search for a destination
    And create a new alert with specified dates
    Then should see the confirmation message
    And should be able to logout successfully


  Scenario: Edit Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When navigate to the list of alerts
    And edit an existing alert
    Then should see the confirmation message for alert edited
    And should be able to logout successfully



  Scenario: Delete Alert in Production Environment
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When navigate to the list of alerts
    And delete an existing alert
    Then should see the confirmation message for alert deleted
    And should be able to logout successfully
