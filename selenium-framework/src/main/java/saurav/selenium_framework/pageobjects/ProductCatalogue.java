package saurav.selenium_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saurav.selenium_framework.AbstractComponents.ReuseableComponents;

public class ProductCatalogue extends ReuseableComponents{
	
	//page object design model
	//locating all the variables and locators to be used in the landing page in this class.

	
		WebDriver driver;
		public ProductCatalogue(WebDriver driver) {
			//initialization
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver, this);    //Giving the scope of driver to the PageFactory.
		}
	//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		By productBy = By.cssSelector(".mb-3");
		By toastmessage = By.cssSelector("#toast-container");
		@FindBy(css=".ng-animating")
		WebElement nganimationmessage;
		
		public List<WebElement> getProductList() {
			 waitForElementToApper(productBy);
			return products;
		}
		
		public WebElement getProductByName(String productName) {
			WebElement prod = getProductList().stream()
					.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
					.orElse(null);
			return prod;
		}
		public CartPage addProductToCart(String productName) {
			WebElement prod = getProductByName(productName);
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			waitForElementToApper(toastmessage);
			waitForElementTodisAppear(nganimationmessage);
			return new CartPage(driver);
			

		}
}
