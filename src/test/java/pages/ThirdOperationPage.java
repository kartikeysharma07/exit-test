package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ThirdOperationPage extends BasePage {
	
	WebDriverWait wait ;
	public ThirdOperationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void Advertise() {
		driver.findElement(By.xpath("//a[@title='Dropdown with more help links']")).click();
		driver.findElement(By.xpath("//a[@title='Advertise']")).click();
		driver.findElement(By.xpath("//a[@href='/register']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Kartikey Sharma");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9919111111");
		driver.findElement(By.xpath("//input[@name='email-id']")).sendKeys("hello@gmail.com");
		driver.findElement(By.xpath("//input[@name='primary-password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//input[@name='confirm-password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String current_title=driver.getTitle();
		String expected_title="Flipkart Ads Platform";
		Assert.assertEquals(current_title,expected_title,"Not on the Flipkart Ads platform");
	}


	public void Furniture() {
		WebElement furniture_link=driver.findElement(By.xpath("//span[contains(text(),'Home & Furniture')]"));
		furniture_link.click();
		String section="Furniture Studio";
		String item="Shoe Racks";
		driver.findElement(By.xpath("//a[contains(text(), \"" + section + "\")]")).click();
		String current_title=driver.getTitle();
		String expected_title="Ikfs Store Online - Buy Ikfs Online at Best Price in India | Flipkart.com";
		Assert.assertEquals(current_title, expected_title,"Not on the furniture page");
	}


	public void GiftCards() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[@aria-label='Gift Cards']")).click();
		driver.findElement(By.xpath("//img[@src='https://rukminim2.flixcart.com/fk-p-flap/100/100/image/93881a4d42932961.jpg?q=50']")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'KnKsm9') and contains(., 'ADD A GIFT CARD')]")).click();
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, "https://www.flipkart.com/account/login?ret=/account/giftcard?type=add","Not on the login page");
	}
	
	//need to change
	public void GiftCardPersonalrequirements() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[@aria-label='Gift Cards']")).click();
		driver.findElement(By.xpath("//img[@src='https://rukminim2.flixcart.com/fk-p-flap/100/100/image/93881a4d42932961.jpg?q=50']")).click();
		driver.findElement(By.xpath("//input[@name='recipient-email[]']")).sendKeys("hello@gmail.com");
		driver.findElement(By.xpath("//input[@name='recipient-name[]']")).sendKeys("Kartikey Sharma");
		driver.findElement(By.xpath("//input[@name='recipient-name[]']")).sendKeys("Kartikey Sharma");
		WebElement dropdown = driver.findElement(By.name("voucher-value[]"));
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("500");
	    driver.findElement(By.xpath("//button[@class='QqFHMw AsTLnx _7Pd1Fp']")).submit();
	    String actual_title=driver.getTitle();
	    String expected_title="Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
	    Assert.assertEquals(actual_title,expected_title);
	}
	
	public void Checking_Cart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		driver.findElement(By.xpath("//button[@class='QqFHMw aEsfVh _7Pd1Fp']")).click();
		WebElement email_box=driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
		wait.until(ExpectedConditions.elementToBeClickable(email_box));
		email_box.sendKeys("9919520904");
		String current_title=driver.getTitle();
		String expected_title="Shopping Cart | Flipkart.com";
		Assert.assertEquals(current_title, expected_title,"Not on the login page");
	}


	public void Travel() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[@aria-label='Travel']")).click();
		driver.findElement(By.xpath("//img[@src='https://rukminim2.flixcart.com/fk-p-flap/50/50/image/f5e49d1f18e0b545.jpg?q=50']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@src='https://rukminim2.flixcart.com/fk-p-flap/50/50/image/1d9cd2285f4108e2.jpg?q=50']")).click();
		driver.navigate().back();
		String actual_title=driver.getTitle();
		String expected_title="Travel Bgmh Tnc Store Online - Buy Travel Bgmh Tnc Online at Best Price in India | Flipkart.com";
		Assert.assertEquals(actual_title,expected_title);
	}

}
