package saurav.selenium_framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saurav.selenium_framework.AbstractComponents.ReuseableComponents;

public class LandingPage extends ReuseableComponents{
	
	//page object design model
	//locating all the variables and locators to be used in the landing page in this class.

	
		WebDriver driver;
		public LandingPage(WebDriver driver) {
			//initialization
			super(driver);   //sending driver from child to parents using super keyword>
			this.driver= driver;
			PageFactory.initElements(driver, this);    //Giving the scope of driver to the PageFactory.
		}
	// WebElement userEmail =	driver.findElement(By.id("userEmail"));
	 //using PageFactory method for alternative of above steps:
	 
	 @FindBy(id="userEmail")   // this will server as driver.findElement(By.id("userEmail") in the runtime.
	 WebElement userEmail;

	 @FindBy(id="userPassword")
	 WebElement userpassword;
	 
	 @FindBy(id="login")
	 WebElement login;
	 
	 
	 public ProductCatalogue loginApplication(String email,String password) {
		 userEmail.sendKeys(email);
		 userpassword.sendKeys(password);
		 login.click();
		 ProductCatalogue productcataloguepage = new ProductCatalogue(driver);
		 return productcataloguepage;
	 }
	 public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
}
