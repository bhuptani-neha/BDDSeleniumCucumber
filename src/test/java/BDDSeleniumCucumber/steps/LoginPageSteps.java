package BDDSeleniumCucumber.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import BDDSeleniumCucumber.common.TestContext;

public class LoginPageSteps {
	
	private TestContext testContext;
	private WebDriver driver = SetupSteps.driver;
	private String userEmail = UserInfo.userEmail; 
	private String userPwd = UserInfo.userPwd;
	
	public LoginPageSteps(TestContext testContext) {
		this.testContext = testContext;
		
	}
	
	@When("User clicks Logout")
	public void user_clicks_logout() {
		testContext.getPageObjectManager(driver).getProfilePage().getLogOutButton().click();
	}

	@Then("Create Account Button Appears")
	public void create_account_button_appears() {
		assertTrue(testContext.getPageObjectManager(driver).getLoginPage().getCreateAccountButton().isDisplayed());
	}

	@When("User enters a above created Email address")
	public void user_enters_a_above_created_email_address() {
		testContext.getPageObjectManager(driver).getLoginPage().getEmailTextField().sendKeys(testContext.getUser().getUserEmail());
	}
	
	@When("User enters a his Email address")
	public void user_enters_a_his_email_address() {
		testContext.getPageObjectManager(driver).getLoginPage().getEmailTextField().sendKeys(UserInfo.userEmail);
	}
	
	@When("User enters a his Password")
	public void user_enters_a_his_password() {
		testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys(UserInfo.userPwd);
	}

	@When("User enter above entered Password")
	public void user_enter_above_entered_password() {
		testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys(testContext.getUser().getUserPassword());
	}

	@When("User click on Sign In Button")
	public void user_click_on_sign_in_button() {
		testContext.getPageObjectManager(driver).getLoginPage().getSignInButton().click();
	}
	
	@When("User enter above wrong Password {string}")
	public void user_enter_above_wrong_password(String pwd) {
		testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys(pwd);
	}
	
	@Then("User is given alert message {string}")
	public void user_is_given_alert_message(String msg) {
		assertTrue(testContext.getPageObjectManager(driver).getLoginPage().getAlertLabel().getText().contains(msg));
	}

	@Then("User is given alert {string}")
	public void user_is_given_alert(String msg) {
		assertTrue(testContext.getPageObjectManager(driver).getLoginPage().getAlertLabel().getText().contains(msg));
	}
	
	@When("User enters {string} and {string} and clicks on Sign in Button")
	public void user_enters_and_and_clicks_on_sign_in_button(String userEmail, String userPwd) {
		
		if(userEmail.equals("usremail")) {
			testContext.getPageObjectManager(driver).getLoginPage().getEmailTextField().sendKeys(UserInfo.userEmail);
		}else {
			testContext.getPageObjectManager(driver).getLoginPage().getEmailTextField().sendKeys(userEmail);
		}
		
		if(userPwd.equals("userpwd")) {
			testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys(UserInfo.userPwd);		
		}else {
			testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys(userPwd);	
		}
		
		testContext.getPageObjectManager(driver).getLoginPage().getSignInButton().click();
	}
	
	@When("User enter blank password")
	public void user_enter_blank_password() {
		testContext.getPageObjectManager(driver).getLoginPage().getPasswordTextField().sendKeys("");
	}

	@When("User enters blank email")
	public void user_enters_blank_email() {
		testContext.getPageObjectManager(driver).getLoginPage().getEmailTextField().sendKeys("");
	}



}
