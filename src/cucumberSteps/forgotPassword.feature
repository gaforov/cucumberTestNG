Feature: Retrieve forgotten password

  Scenario: retrieve password
    Given user is on website homepage
    When user clicks on forgot password link
    And user enters email address
    And user clicks on retrieve password button
    Then user taken to confirmation page