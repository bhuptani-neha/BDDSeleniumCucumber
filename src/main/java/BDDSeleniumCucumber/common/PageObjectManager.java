package BDDSeleniumCucumber.common;

import org.openqa.selenium.WebDriver;

import BDDSeleniumCucumber.pages.HomePage;
import BDDSeleniumCucumber.pages.LoginPage;
import BDDSeleniumCucumber.pages.ProfilePage;
import BDDSeleniumCucumber.pages.RegistrationPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private HomePage homePage;
	private ProfilePage profilePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}
	
	public RegistrationPage getRegistrationPage() {
		if(registrationPage == null) {
			registrationPage = new RegistrationPage(driver);
		}
		return registrationPage;
	}
	
	public HomePage getHomePage() {
		if(homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	
	public ProfilePage getProfilePage() {
		if(profilePage == null) {
			profilePage = new ProfilePage(driver);
		}
		return profilePage;
	}
}
