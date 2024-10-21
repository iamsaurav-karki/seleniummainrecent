package saurav.selenium_framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import saurav.selenium_framework.pageobjects.CartPage;

public class ReuseableComponents {
	WebDriver driver;
	public ReuseableComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
     WebElement cartbutton;
	public void waitForElementToApper(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public CartPage goToCartPage() {
		cartbutton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	public void waitForElementTodisAppear(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
