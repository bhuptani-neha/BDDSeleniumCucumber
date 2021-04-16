package BDDSeleniumCucumber.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import BDDSeleniumCucumber.common.CommonTask;
import BDDSeleniumCucumber.common.DriverManager;
import BDDSeleniumCucumber.common.TestContext;

public class RegistrationPageSteps {
	
	private TestContext testContext;
	private WebDriver driver = SetupSteps.driver;
	private String userEmail; 
	private String userPwd;
	
	public RegistrationPageSteps(TestContext testContext) {
		this.testContext = testContext;
		
	}
	
	@Given("Navigate to AutomationPractice Website HomePage")
	public void navigate_to_automation_practice_website_home_page() {
		CommonTask.NavigateTo(driver,"http://automationpractice.com");
	}

	@When("User clicks on Sign in Button")
	public void user_clicks_on_sign_in_button() {
	    testContext.getPageObjectManager(driver).getHomePage().getSignInButton().click();
	}

	@Then("Create an Account Link is displayed")
	public void create_an_account_link_is_displayed() {
		assertTrue(testContext.getPageObjectManager(driver).getLoginPage().getCreateAccountButton().isDisplayed());
	}

	
	@Given("User is on Sign In Page")
	public void user_is_on_sign_in_page() {
		assertTrue(testContext.getPageObjectManager(driver).getLoginPage().getCreateAccountButton().isDisplayed());
	}

	@When("User enters a {string} Email address")
	public void user_enters_a_email_address(String email) {
		String newEmail = email.substring(0, email.indexOf("@")) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) 
				+  email.substring(email.indexOf("@"));
		testContext.getUser().setUserEmail(newEmail);
		userEmail = newEmail; 
		testContext.getPageObjectManager(driver).getLoginPage().getCreateEmailTextField().clear();
		testContext.getPageObjectManager(driver).getLoginPage().getCreateEmailTextField().sendKeys(newEmail);
	}

	@When("Clicks on Create Account Button")
	public void clicks_on_create_account_button() {
		testContext.getPageObjectManager(driver).getLoginPage().getCreateAccountButton().click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {}
	}

	@Then("A button Register appears.")
	public void a_button_register_appears() {
		assertTrue(testContext.getPageObjectManager(driver).getRegistrationPage().getRegisterButton().isDisplayed());
	}

	@Then("{string} appears in EmailID Field")
	public void appears_in_email_id_field(String email) {
		assertEquals(testContext.getUser().getUserEmail(),testContext.getPageObjectManager(driver).getRegistrationPage().getEmailTextField().getAttribute("value"));
	}

	@Given("User is on Registration Page with {string} email")
	public void user_is_on_registration_page_with_email(String email) {
		//assertEquals(testContext.getUser().getUserEmail(),testContext.getPageObjectManager(driver).getRegistrationPage().getEmailTextField().getAttribute("value"));
	}

	@When("User enter all the below information:")
	public void user_enter_all_the_below_information(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> rows = dataTable.asLists(String.class);
		
		testContext.getPageObjectManager(driver).getRegistrationPage().getFirstNameTextField().sendKeys(rows.get(2).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getLastNameTextField().sendKeys(rows.get(3).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getAddressTextField().sendKeys(rows.get(4).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getCityTextField().sendKeys(rows.get(5).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getStateDropdown().selectByVisibleText(rows.get(6).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getPostalCodeTextField().sendKeys(rows.get(7).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getNumberTextField().sendKeys(rows.get(8).get(1));
		testContext.getPageObjectManager(driver).getRegistrationPage().getTitleRadioMrs().click();
		testContext.getPageObjectManager(driver).getRegistrationPage().getPasswordTextField().sendKeys(rows.get(9).get(1));
		testContext.getUser().setUserPassword(rows.get(9).get(1));
		userPwd = rows.get(9).get(1);
	}

	@When("User clicks Register")
	public void user_clicks_register() {
		testContext.getPageObjectManager(driver).getRegistrationPage().getRegisterButton().click();
	}

	@Then("User is redirected to A Profile Page with title {string}")
	public void user_is_redirected_to_a_profile_page_with_title(String title) {
		assertEquals(title,testContext.getPageObjectManager(driver).getProfilePage().getTitle());
	}

}
