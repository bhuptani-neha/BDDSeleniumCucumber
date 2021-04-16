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
  Scenario: Login with Wrong Password
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    When User enters a his Email address
    And User enter above wrong Password "12345"
    And User click on Sign In Button
    Then User is given alert message "Authentication failed."
    
    @CallSetup @CallTearDown
  Scenario: Login with Blank Password
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    When User enters a his Email address
    And User enter blank password
    And User click on Sign In Button
    Then User is given alert message "Password is required."
    
    @CallSetup @CallTearDown
  Scenario: Login with Blank Email
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    When User enters blank email
    And User enters a his Password
    And User click on Sign In Button
    Then User is given alert message "An email address required."
    
     @CallSetup @CallTearDown
  Scenario: LogOut
    Given Navigate to AutomationPractice Website HomePage
    And User clicks on Sign in Button
    And User enters a his Email address
    And User enters a his Password
    And User click on Sign In Button
    When User clicks Logout
    Then Create Account Button Appears