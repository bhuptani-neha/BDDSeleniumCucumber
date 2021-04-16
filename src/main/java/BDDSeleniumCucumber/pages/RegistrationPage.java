package BDDSeleniumCucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailTextField() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getFirstNameTextField() {
		return driver.findElement(By.id("customer_firstname"));
	}

	public WebElement getLastNameTextField() {
		return driver.findElement(By.id("customer_lastname"));
	}
	
	public WebElement getPasswordTextField() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getAddressTextField() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getCityTextField() {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement getPostalCodeTextField() {
		return driver.findElement(By.id("postcode"));
	}
	
	public WebElement getNumberTextField() {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public WebElement getTitleRadioMrs() {
		return driver.findElement(By.id("id_gender2"));
	}
	
	public Select getStateDropdown() {
		return new Select(driver.findElement(By.id("id_state")));
	}
	
	public WebElement getRegisterButton() {
		return driver.findElement(By.id("submitAccount"));
	}
	
}
