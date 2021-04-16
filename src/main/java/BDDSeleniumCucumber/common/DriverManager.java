package BDDSeleniumCucumber.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setUpBrowser
	() {
		String browserType = "chrome";
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver(); 
			break;
		case "firefox":
			//driver = initFirefoxDriver(appURL);
			break;
		default:
			
		}

		
		driver.manage().window().maximize();
		
	}
	
	public void tearDownDriver() {
		if(driver!= null) {
			driver.quit();
		}
	}
}
