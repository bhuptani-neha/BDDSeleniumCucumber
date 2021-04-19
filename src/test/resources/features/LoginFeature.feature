Feature: Login Functionality
  Login as a user to shopping portal

  @CallSetup @CallTearDown @SetCredentials
  Scenario Outline: Create a user and login with created userdetails
    Given Navigate to AutomationPractice Website HomePage
    When User creates account using "AutomationBDDUser@training.com"
    And User registers with all the below information:
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
    And User Logout of the system
    And User signs in using credentials <email> and <password>
    Then User is successfully logged in.
    Examples: 
      | email  | password |
      | "usremailCreated" |     "userpwdCreated" |
    
    
  @CallSetup @CallTearDown
  Scenario Outline: Login Scenarios with Blank Email, Pwd and Wrong Pwd
    Given Navigate to AutomationPractice Website HomePage
    When User clicks on Sign in Button
    When User signs in using credentials <email> and <password>
    Then User is given alert <message>
    
     Examples: 
      | email  | password | message  |
      | "" |     "userpwd" | "An email address required." |
      | "usremail" |     "" | "Password is required."    |
      | "usremail" |     "12345" | "Authentication failed."    |
      
      
      
  @CallSetup @CallTearDown
  Scenario Outline: LogOut
    Given Navigate to AutomationPractice Website HomePage
    And User signs in using credentials <email> and <password>
    When User clicks Logout
    Then User is logged out of Profile
    
     Examples: 
      | email  | password |
      | "usremail" |     "userpwd" |
