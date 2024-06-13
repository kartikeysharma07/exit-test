package pages;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.ThirdLocators;
import utility.AssertionClass;

public class ThirdOperationPage extends BasePage {
	
	WebDriverWait wait ;
	public ThirdOperationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//here we are selecting the three-dots dropdown and inside the dropdown we are selecting the Advertise link
	//after going to advertise page we are registering the user credentials
	public void Advertise(String name,String email, String mobile, String password) {
		driver.findElement(By.xpath(ThirdLocators.DROPDOWN)).click();
		driver.findElement(By.xpath(ThirdLocators.ADVERTISE)).click();
		driver.findElement(By.xpath(ThirdLocators.REGISTER)).click();
		driver.findElement(By.xpath(ThirdLocators.NAME_BOX)).sendKeys(name);
		driver.findElement(By.xpath(ThirdLocators.MOBILE_BOX)).sendKeys(mobile);
		driver.findElement(By.xpath(ThirdLocators.EMAIL_BOX)).sendKeys(email);
		driver.findElement(By.xpath(ThirdLocators.PASSOWORD)).sendKeys(password);
		driver.findElement(By.xpath(ThirdLocators.CONFIRM_PASSWORD)).sendKeys(password);
		driver.findElement(By.xpath(ThirdLocators.SUBMIT)).click();
		String current_title=driver.getTitle();
		String expected_title=AssertionClass.ADPAGETITLE;
		Assert.assertEquals(current_title,expected_title,AssertionClass.ADVERTISE_ERROR_MESSAGE);
	}

	//in the home page we are selecting the Furniture icons to select a Furniture
	public void Furniture() {
		WebElement furniture_link=driver.findElement(By.xpath(ThirdLocators.FURNITURE));
		furniture_link.click();
		String section="Furniture Studio";
		driver.findElement(By.xpath("//a[contains(text(), \"" + section + "\")]")).click();
		String current_title=driver.getTitle();
		String expected_title=AssertionClass.FURNITURETITLE;
		Assert.assertEquals(current_title, expected_title,AssertionClass.FURNITURE_ERROR_MESSAGE);
	}

	//in the footer section we are checking the gift card link.
	public void GiftCards() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(ThirdLocators.GIFTCARDS)).click();
		driver.findElement(By.xpath(ThirdLocators.SELECTGIFT)).click();
		driver.findElement(By.xpath(ThirdLocators.ADDCARD)).click();
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, AssertionClass.GIFTCARDURL,AssertionClass.LOGIN_SIGNUP_ERROR_FAILED);
	}
	
	//Here we are checking the personal requirements section present in the GiftCard link.
	public void GiftCardPersonalrequirements(String name,String email, String mobile, String password) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(ThirdLocators.GIFTCARDS)).click();
		driver.findElement(By.xpath(ThirdLocators.SELECTPERSONALCARD)).click();
		driver.findElement(By.xpath(ThirdLocators.RECEPIENT_EMAIL)).sendKeys(email);
		driver.findElement(By.xpath(ThirdLocators.RECPIENT_NAME)).sendKeys(name);
		WebElement dropdown = driver.findElement(By.name(ThirdLocators.VOUCHER_VALUE));
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("500");
	    driver.findElement(By.xpath(ThirdLocators.DROPDOWN_SUBMIT)).submit();
	    String actual_title=driver.getTitle();
	    String expected_title=AssertionClass.PAYMENTTITLE;
	    Assert.assertEquals(actual_title,expected_title,AssertionClass.PAYMENT_ERROR_MESSAGE);
	}
	
	//in the home page section we are clicking the cart button and then we are login with the credential
	public void Checking_Cart(String mobile) {
		driver.findElement(By.xpath(ThirdLocators.CART)).click();
		driver.findElement(By.xpath(ThirdLocators.CART_SUBMIT)).click();
		WebElement email_box=driver.findElement(By.xpath(ThirdLocators.EMAIL_CART));
		wait.until(ExpectedConditions.elementToBeClickable(email_box));
		email_box.sendKeys(mobile);
		String current_title=driver.getTitle();
		String expected_title=AssertionClass.CARTTITLE;
		Assert.assertEquals(current_title, expected_title,AssertionClass.LOGIN_SIGNUP_ERROR_FAILED);
	}

	
	//here we are clicking the Travel icon present in the Travel section.
	public void Travel() {
		driver.findElement(By.xpath(ThirdLocators.TRAVEL)).click();
		driver.findElement(By.xpath(ThirdLocators.TRAVEL_SEARCH)).click();
		String actual_title=driver.getCurrentUrl();
		String expected_title=base_url;
		Assert.assertNotEquals(actual_title,expected_title,AssertionClass.PAGE_ERROR_MESSAGE);
	}

}
