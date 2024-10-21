package saurav.selenium_framework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class submitordertest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String Productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		ProductCatalogue productcataloguepage= landingpage.loginApplication("sauravv@gmail.com", "@Sauravv123");
		List<WebElement> products = productcataloguepage.getProductList();
		productcataloguepage.addProductToCart(Productname);
		
		CartPage cart = productcataloguepage.goToCartPage();
		Boolean match = cart.VarifyProductDisplayed(Productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage =cart.goTOCheckout();
		checkoutpage.selectCountry("nepal");
		confirmationPage confirmationPage = checkoutpage.submitOrder();
		String confirmmsg = confirmationPage.getconfiramtionmsg();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));

	}

}
