package saurav.selenium_framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saurav.selenium_framework.AbstractComponents.ReuseableComponents;

public class CheckoutPage extends ReuseableComponents {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryselector;
	@FindBy(css=".ta-item")
	WebElement selectnepal;
	@FindBy(css="[class*='btnn']")
	WebElement confirmbutton;
	
	By results = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String Countryname) {
		Actions a = new Actions(driver);
		a.sendKeys(countryselector, Countryname).build().perform();
		waitForElementToApper(results);
		selectnepal.click();
	}
	
	public confirmationPage submitOrder() {
		confirmbutton.click();
		return new confirmationPage(driver);
	}

}
