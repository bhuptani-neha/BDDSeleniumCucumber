package BDDSeleniumCucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	private WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.findElement(By.className("page-heading")).getText();
	}
	
	public WebElement getLogOutButton() {
		return driver.findElement(By.className("logout"));
	}
	
}
