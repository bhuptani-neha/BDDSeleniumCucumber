package BDDSeleniumCucumber.common;

import org.openqa.selenium.WebDriver;

public class CommonTask {
	
	public static void NavigateTo(WebDriver driver, String url) {
		driver.get(url);
		
	}

}
