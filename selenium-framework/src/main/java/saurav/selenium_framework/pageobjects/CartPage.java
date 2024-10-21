package saurav.selenium_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saurav.selenium_framework.AbstractComponents.ReuseableComponents;

public class CartPage extends ReuseableComponents{

	// page object design model
	// locating all the variables and locators to be used in the landing page in
	// this class.

	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	List<WebElement> Producttitles;

	@FindBy(css = ".totalRow button")
	WebElement checkoutele;

	public CartPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Giving the scope of driver to the PageFactory.
	}

	public Boolean VarifyProductDisplayed(String productName) {
		Boolean match = Producttitles.stream().anyMatch(cartproduct -> cartproduct.getText().equals(productName));
		return match;
	}

	public CheckoutPage goTOCheckout() {
		checkoutele.click();
		return new CheckoutPage(driver);
	}
}
