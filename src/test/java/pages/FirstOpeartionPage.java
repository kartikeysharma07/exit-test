package pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import locators.FirstLocators;
import utility.AssertionClass;




public class FirstOpeartionPage extends BasePage {
	
	WebElement search_box;
	
	
	public FirstOpeartionPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(wait_time));
	}
	
	//this opeartion will search the product in the website
	public void Search(String item,String model) {
		
		search_box=driver.findElement(By.xpath(FirstLocators.SEARCH_BOX));
		search_box.sendKeys(item);
		search_box.submit();
		String current_url=driver.getCurrentUrl();
		String url=base_url;
		Assert.assertEquals(current_url,url,AssertionClass.SEARCH_ERROR_MESSAGE);
		WebElement search_brand=driver.findElement(By.xpath(FirstLocators.SEARCH_BRAND));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", search_brand);
		wait.until(ExpectedConditions.elementToBeClickable(search_brand));
		search_brand.sendKeys(model);
	}
	
	//in this method we are going to test for opeartion of grocery
	//here we are searching for the snacks
	//here we are setting the pincode then searching for item and adding it to cart
	public void Grocery(String pin,String item) {
		WebElement grocery_button=driver.findElement(By.xpath(FirstLocators.GROCERY_BUTTON));
		grocery_button.click();
		String expected_title=driver.getTitle();
		String current_title=driver.getTitle();
		Assert.assertEquals(current_title,expected_title,AssertionClass.GROCERY_ERROR_MESSAGE);
		WebElement pincode=driver.findElement(By.xpath(FirstLocators.PINCODE));
		pincode.sendKeys(pin);
		pincode.submit();
		search_box=driver.findElement(By.xpath(FirstLocators.SEARCH_BOX));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(item);
		search_box.submit();
		WebElement add_item=driver.findElement(By.xpath(FirstLocators.ADD_ITEM));
		wait.until(ExpectedConditions.elementToBeClickable(add_item));
		add_item.click();
		String current_url=driver.getCurrentUrl();
		String url=base_url;
		Assert.assertNotEquals(current_url, url,AssertionClass.ORDER_ERROR_MESSAGE);
		
	}


	//in this method we are going to add an item to cart
	//in this we are searching for the specific product and getting it's details
	//then we will add the product in the cart
	public void SpecficProduct() {
		search_box=driver.findElement(By.xpath(FirstLocators.SEARCH_BOX));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys("SAMSUNG Galaxy F55 5G (Apricot Crush, 256 GB)");
		search_box.submit();
		List<WebElement> products = driver.findElements(By.xpath(FirstLocators.PRODUCT_LIST));
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
		driver.findElement(By.xpath(FirstLocators.ADD_TO_CART)).click();
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath(FirstLocators.PLACE_ORDER)).click();
		String current_url=driver.getCurrentUrl();
		String url=base_url;
		Assert.assertNotEquals(current_url, url,AssertionClass.PRODUCT_ERROR_MESSAGE);
		
	}
	
	
	//here we are writing the script for automating user to get details on how he would become the seller
	//in the flipkart to sell his 
	public void BecomeSeller(String mobile,String email) {
		WebElement seller=driver.findElement(By.xpath(FirstLocators.SELLER));
		wait.until(ExpectedConditions.elementToBeClickable(seller));
		seller.click();
		String current_title=driver.getTitle();
		String expected_title=AssertionClass.SELLERTITLE;
		Assert.assertEquals(current_title,expected_title,AssertionClass.SELLER_ERROR_MESSAGE);
		driver.findElement(By.xpath(FirstLocators.START_SELLING)).click();
		WebElement mobile_box=driver.findElement(By.xpath(FirstLocators.MOBILE_BOX));
		mobile_box.sendKeys(mobile);
		WebElement email_box=driver.findElement(By.xpath(FirstLocators.EMAIL_BOX));
		email_box.sendKeys(email);
		driver.findElement(By.xpath(FirstLocators.REGISTER)).click();
		String current_page_url=driver.getCurrentUrl();
		Boolean value=current_page_url.toLowerCase().contains("signup");
		Assert.assertTrue(value, AssertionClass.SELLER_SIGNUP_ERROR_MESSAGE);
		
	}
	
	
	//here in this we are selecting the dropdown icon from the homepage that selects the fashion
	//inside we have different section and for each section we have different products for it.
	public void Fashion(String section,String item) {
		WebElement fashion_link=driver.findElement(By.xpath(FirstLocators.FASHION_LINK));
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
		String url=base_url;
		Assert.assertNotEquals(current_url, url,AssertionClass.PRODUCT_ERROR_MESSAGE);
	}
	
	//selecting the threedots icon in the homepage and selecting the options present inside that.
	public void Notifications() {
		driver.findElement(By.xpath(FirstLocators.DROPDOWN)).click();
		driver.findElement(By.xpath(FirstLocators.CUSTOMER_CARE_LINK)).click();
		driver.findElement(By.xpath(FirstLocators.MANAGE_ORDER)).click();
		driver.navigate().back();
		driver.findElement(By.xpath(FirstLocators.REFUND_ORDER)).click();
		driver.navigate().back();	
		String current_page_title=driver.getTitle();
		String expected_page_title=AssertionClass.HOMETITLE;
		Assert.assertEquals(current_page_title, expected_page_title,AssertionClass.NOTIFICATION_ERROR_PAGE);
	}
	
	//selecting the twowheeler icon present in the homepage
	//two wheeler we are selecting the petrol vehicle options
	public void TwoWheeler() {		
		
		driver.findElement(By.xpath(FirstLocators.TWO_WHEELER)).click();
	    driver.findElement(By.xpath(FirstLocators.VEHICLE)).click();
	    String current_url=driver.getCurrentUrl();
	    String expected_url=base_url;
	    Assert.assertNotEquals(current_url, expected_url,AssertionClass.PAGE_ERROR_MESSAGE);
	    
	}
}
