Feature: 
  Book cart application

  Scenario: 
    Login should be success

    Given User should navigate to the application
    And user click on the login link
    And user enter the username as Sakthi
    And User enter the password as pass1234
    When user click the login button
    Then login should be success

  Scenario: 
    Login should be fail
    Giver user should navigate to the application 
    Ans User clicks on the the login link

    And user enter the username as Ortoni
    And User enter the password as pass12345
    When user click the login button
    But login should fail
