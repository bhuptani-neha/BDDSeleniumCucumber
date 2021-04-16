package BDDSeleniumCucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
}
