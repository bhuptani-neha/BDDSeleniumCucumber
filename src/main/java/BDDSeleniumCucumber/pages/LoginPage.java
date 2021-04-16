package BDDSeleniumCucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(By.id("SubmitCreate"));
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getCreateEmailTextField() {
		return driver.findElement(By.id("email_create"));
	}
	
	public WebElement getEmailTextField() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordTextField() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getAlertLabel() {
		return driver.findElement(By.className("alert-danger"));
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
