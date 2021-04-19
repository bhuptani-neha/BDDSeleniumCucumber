Feature: Login Functionality
  Login as a user to shopping portal

  @CallSetup @CallTearDown @SetCredentials
  Scenario: Create a user and login with created userdetails
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    And User enters a "AutomationBDDUser@training.com" Email address
    And Clicks on Create Account Button
    And User enter all the below information:
      | Fields    | Values              |
      | Title     | Mrs.                |
      | FirstName | TestUser            |
      | LastName  | TestLast            |
      | Address   | Street, 12, Company |
      | City      | Georgia             |
      | State     | Georgia             |
      | Postal    |               22222 |
      | Phone     |           123456789 |
      | Password  | testing             |
    And User clicks Register
    Then User is redirected to A Profile Page with title "MY ACCOUNT"
    When User clicks Logout
    Then Create Account Button Appears
    When User enters a above created Email address
    And User enter above entered Password
    And User click on Sign In Button
    Then User is redirected to A Profile Page with title "MY ACCOUNT"
    
    
     @CallSetup @CallTearDown
  Scenario Outline: Login Scenarios with Blank Email, Pwd and Wrong Pwd
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    When User enters <email> and <password> and clicks on Sign in Button
    Then User is given alert <message>
    
     Examples: 
      | email  | password | message  |
      | "" |     "userpwd" | "An email address required." |
      | "usremail" |     "" | "Password is required."    |
      | "usremail" |     "12345" | "Authentication failed."    |
      
      @CallSetup @CallTearDown
  Scenario Outline: LogOut
    Given Navigate to AutomationPractice Website HomePage
    And User clicks on Sign in Button
    And User enters <email> and <password> and clicks on Sign in Button
    When User clicks Logout
    Then Create Account Button Appears
    
     Examples: 
      | email  | password |
      | "usremail" |     "userpwd" |
