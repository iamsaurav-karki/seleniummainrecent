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

public class endtoend {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String Productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sauravv@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@Sauravv123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)");
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// ng-animating
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ng-animating")));
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[routerlink*='cart']"))));
		element.click();
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match =  cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(Productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ne");
//		List<WebElement> country = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
//		for(WebElement mycountry: country) {
//			if(mycountry.getText().equalsIgnoreCase("Nepal")) {
//				wait.until(ExpectedConditions.elementToBeClickable(mycountry));
//				mycountry.click();
//				break;
//			}
//		}
		
		//using actions classs:
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"Nepal").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item")).click();
		driver.findElement(By.cssSelector("[class*='btnn']")).click();
		String thanktext = driver.findElement(By.className("hero-primary")).getText();
		Assert.assertEquals(thanktext, "THANKYOU FOR THE ORDER.");
		
		

		
		
	}

}
