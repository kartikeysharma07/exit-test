package pages;
import static org.testng.Assert.assertThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class FirstOpeartionPage extends BasePage {
	
	WebElement search_box;
	WebDriverWait wait ;
	
	public FirstOpeartionPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//this opeartion will search the product in the website
	public void Search(String item,String model) {
		
		search_box=driver.findElement(By.xpath("//input[@name='q']"));
		search_box.sendKeys(item);
		search_box.submit();
		String current_title=driver.getTitle();
		String expected_title="Phones- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		Assert.assertEquals(current_title,expected_title,"not on the search page");
		WebElement search_brand=driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", search_brand);
		wait.until(ExpectedConditions.elementToBeClickable(search_brand));
		search_brand.sendKeys(model);
	}
	
	//in this method we are going to test for opeartion of grocery
	//here we are searching for the snacks
	public void Grocery(String pin,String item) {
		WebElement grocery_button=driver.findElement(By.xpath("//img[@alt='Grocery']"));
		grocery_button.click();
		String expected_title=driver.getTitle();
		String current_title=driver.getTitle();
		Assert.assertEquals(current_title,expected_title,"not on the grocery page");
		WebElement pincode=driver.findElement(By.xpath("//input[@name='pincode']"));
		pincode.sendKeys(pin);
		pincode.submit();
		
		search_box=driver.findElement(By.xpath("//input[@name='q']"));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(item);
		search_box.submit();
		WebElement add_item=driver.findElement(By.xpath("//div[@class='_75nlfW']//button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(add_item));
		add_item.click();
		driver.findElement(By.xpath("//a[@href='/viewcart?exploreMode=true&preference=GROCERY']")).click();
		String current_url=driver.getCurrentUrl();
		String url="https://www.flipkart.com/";
		Assert.assertNotEquals(current_url, url,"Not on the Order Page");
		
	}


	//in this method we are going to add an item to cart
	//in this we are searching for the specific product and getting it's details
	public void SpecficProduct() {
		search_box=driver.findElement(By.xpath("//input[@name='q']"));
		search_box.sendKeys("SAMSUNG Galaxy F55 5G (Apricot Crush, 256 GB)");
		search_box.submit();
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
	    for (WebElement product : products) {
	        if (product.getText().contains("SAMSUNG Galaxy F55 5G (Apricot Crush, 256 GB)")) {
	        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
	        	break;
	        }
	    }
	    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2' and contains(., 'Add to cart')]")).click();
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")).click();
		String current_url=driver.getCurrentUrl();
		String url="https://www.flipkart.com/";
		Assert.assertNotEquals(current_url, url,"Not on the correct page");
		
	}
	
	
	public void BecomeSeller(String mobile,String email) {
		WebElement seller=driver.findElement(By.xpath("//a[@title='Become a Seller' and contains(@class, '_1krdK5') and contains(@class, '_3jeYYh')]"));
		wait.until(ExpectedConditions.elementToBeClickable(seller));
		seller.click();
		String current_title=driver.getTitle();
		String expected_title="Sell Online - Start Selling Online on Flipkart Seller Hub";
		Assert.assertEquals(current_title,expected_title,"Not on the seller page");
		driver.findElement(By.xpath("//button[text()='Start Selling']")).click();
		WebElement mobile_box=driver.findElement(By.xpath("//input[@label='Enter Mobile Number']"));
		mobile_box.sendKeys(mobile);
		WebElement email_box=driver.findElement(By.xpath("//input[@label='Email ID']"));
		email_box.sendKeys(email);
		driver.findElement(By.xpath("//button[.//span[text()='Register & Continue']]")).click();
		String current_page_url=driver.getCurrentUrl();
		Boolean value=current_page_url.toLowerCase().contains("signup");
		Assert.assertTrue(value, "Not on the seller dashboard page");
		
	}
	
	public void Fashion(String section,String item) {
		WebElement fashion_link=driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"));
		fashion_link.click();
		driver.findElement(By.xpath("//a[contains(text(), \"" + section + "\")]")).click();
		WebElement product = driver.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		String current_url=driver.getCurrentUrl();
		String url="https://www.flipkart.com/";
		Assert.assertNotEquals(current_url, url,"Not on the correct page");
	}
	
	public void Notifications() {
		driver.findElement(By.xpath("//a[@title='Dropdown with more help links']")).click();
		driver.findElement(By.xpath("//a[@title='24x7 Customer Care']")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'O7NyLz') and .//div[text()='I want to manage my order']]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//div[contains(@class, \"O7NyLz\") and .//div[text()='I want help with returns & refunds']]")).click();
		driver.navigate().back();	
		String current_page_title=driver.getTitle();
		String expected_page_title="Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com";
		Assert.assertEquals(current_page_title, expected_page_title,"Not on the notifications page");
	}
	
	public void TwoWheeler() {		
		
		driver.findElement(By.xpath("//span[contains(text(),'Two Wheelers')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(), 'Petrol Vehicles')]")).click();
	    String current_url=driver.getCurrentUrl();
	    String expected_url="https://www.flipkart.com/";
	    Assert.assertNotEquals(current_url, expected_url,"On the same home page");
	    
	}
	

	
}
