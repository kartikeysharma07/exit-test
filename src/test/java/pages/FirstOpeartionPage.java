package pages;
import static org.testng.Assert.assertThrows;

import java.time.Duration;
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
		WebElement pincode=driver.findElement(By.xpath("//input[@name='pincode']"));
		pincode.sendKeys(pin);
		pincode.submit();
		
		search_box=driver.findElement(By.xpath("//input[@name='q']"));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(item);
		search_box.submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement add_item=driver.findElement(By.xpath("//div[@class='_75nlfW']//button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(add_item));
		add_item.click();
		WebElement cart=driver.findElement(By.xpath("//a[@class='_9Wy27C']"));
		cart.click();
		
	}


//	//in this method we are going to add an item to cart
//	public void AddToCart() {
//		search_box=driver.findElement(By.xpath("//input[@name='q']"));
//		search_box.sendKeys("phone");
//		search_box.submit();
//	}
	
	
	public void BecomeSeller(String mobile,String email) {
		WebElement seller=driver.findElement(By.xpath("//a[@title='Become a Seller' and contains(@class, '_1krdK5') and contains(@class, '_3jeYYh')]"));
		seller.click();
		driver.findElement(By.xpath("//button[text()='Start Selling']")).click();
		WebElement mobile_box=driver.findElement(By.xpath("//input[@label='Enter Mobile Number']"));
		mobile_box.sendKeys(mobile);
		WebElement email_box=driver.findElement(By.xpath("//input[@label='Email ID']"));
		email_box.sendKeys(email);
		driver.findElement(By.xpath("//button[.//span[text()='Register & Continue']]")).click();
	}
	
	public void Fashion(String section,String item) {
		WebElement fashion_link=driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"));
		fashion_link.click();
		driver.findElement(By.xpath("//a[contains(text(), \"" + section + "\")]")).click();
		WebElement product = driver.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
		}
	
	public void Notifications() {
		driver.findElement(By.xpath("//a[@title='Dropdown with more help links']")).click();
		driver.findElement(By.xpath("//a[@title='24x7 Customer Care']")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'O7NyLz') and .//div[text()='I want to manage my order']]")).click();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[contains(@class, \"O7NyLz\") and .//div[text()='I want help with returns & refunds']]")).click();
		driver.navigate().back();	
	}
	
	public void TwoWheeler() {		
		try {
		    driver.findElement(By.xpath("//span[contains(text(),'Two Wheelers')]")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Petrol Vehicles')]")).click();
		    WebElement bike = driver.findElement(By.xpath("//a[contains(text(),'Hero Glamour (Drum) Booking for Ex-Showroom Price')]"));
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(bike));
		    bike.click();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0, 500);");
		    WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button"));
		    element.click();
		} catch (ElementClickInterceptedException e) {
			Assert.fail("Element click intercepted: " + e.getMessage());
		}
		catch(NoSuchElementException e) {
			Assert.fail("No such element found: " + e.getMessage());
		}
	}
	

	
}
