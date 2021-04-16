package BDDSeleniumCucumber.common;

import org.openqa.selenium.WebDriver;

public class TestContext {
	
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	private User user;

	public DriverManager getDriverManager() {
		if(driverManager == null) {
			driverManager = new DriverManager();
		}
		return driverManager;
	}
	
	public User getUser() {
		if(user == null) {
			user = new User();
			
		}
		return user;
	}
	
	public PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager(getDriverManager().getDriver());
		}
		return pageObjectManager;
	}
	
	public PageObjectManager getPageObjectManager(WebDriver driver) {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager(driver);
		}
		return pageObjectManager;
	}

}
