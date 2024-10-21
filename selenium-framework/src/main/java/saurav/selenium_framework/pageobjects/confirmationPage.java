package saurav.selenium_framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saurav.selenium_framework.AbstractComponents.ReuseableComponents;

public class confirmationPage extends ReuseableComponents{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(className="hero-primary")
	WebElement finalconfirmtext;
	
	public String getconfiramtionmsg() {
		return finalconfirmtext.getText();
	}

	

}
