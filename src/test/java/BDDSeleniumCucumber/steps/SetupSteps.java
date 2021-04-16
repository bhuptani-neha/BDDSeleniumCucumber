package BDDSeleniumCucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BDDSeleniumCucumber.common.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetupSteps {

private TestContext testContext;
public static WebDriver driver;
private static boolean executed = false;
	
	@Before("@CallSetup")
	public static WebDriver setUp() {
		String browserType = "chrome";
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver(); 
			driver.manage().window().maximize();
			break;
		case "firefox":
			//driver = initFirefoxDriver(appURL);
			break;
		default:
		}
		return driver;
	}
	
	@After("@CallTearDown")
	public void tearDown() {
		try {
		 	//driver.close();
   	  		driver.quit();
		}
		catch(Exception e) {
			
		}
	}
}
