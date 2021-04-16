
Feature: Registeration Functionality for Automation Website
  In Order to get credentials
  As a User
  I need to Register

	@CallSetup
	Scenario: Go to Sign In Functionality Page
		Given Navigate to AutomationPractice Website HomePage
		When User clicks on Sign in Button
		Then Create an Account Link is displayed
  
 
  Scenario: User successfully registers EmailId
    Given User is on Sign In Page
    When User enters a "AutomationBDDUser@training.com" Email address
    And Clicks on Create Account Button
    Then "AutomationBDDUser@training.com" appears in EmailID Field

	@CallTearDown
  Scenario: User successfully registers an Account
    Given User is on Registration Page with "AutomationBDDUser@training.com" email
    When User enter all the below information:
    | Fields | Values |
    | Title	 | Mrs. |
    | FirstName | TestUser |
    | LastName | TestLast |
    | Address | Street, 12, Company |
    | City | Georgia |
  	| State | Georgia |
  	| Postal | 22222 |
  	| Phone | 123456789 |
  	| Password | testing |
  	And User clicks Register 
  	Then User is redirected to A Profile Page with title "MY ACCOUNT"
    
    
   
