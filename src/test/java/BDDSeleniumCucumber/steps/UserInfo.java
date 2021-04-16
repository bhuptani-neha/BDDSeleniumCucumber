package BDDSeleniumCucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import BDDSeleniumCucumber.common.TestContext;

public class UserInfo {
	
	public static String userEmail; 
	public static String userPwd;
	private TestContext testContext;
	
	public UserInfo(TestContext testContext) {
		this.testContext = testContext;
		
	}
	
	@After("@SetCredentials")
	public void cSetCredentials() {
		userEmail = testContext.getUser().getUserEmail();
		userPwd = testContext.getUser().getUserPassword();
		
	} 
	
		
}
