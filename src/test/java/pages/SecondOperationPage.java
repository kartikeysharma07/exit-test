package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SecondOperationPage extends BasePage {
	
	WebDriverWait wait ;
	public SecondOperationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void Electronics() {
		WebElement electronics_link=driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		electronics_link.click();
		driver.findElement(By.xpath("//a[contains(text(),'Wired Headphones')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Apple EarPods with Lightning Connector Wired Headset')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String current_page_url=driver.getCurrentUrl();
        String url="https://www.flipkart.com/";
        Assert.assertNotEquals(current_page_url, url,"On the Home Page");
	}
	
	
	public void Reward() {
		WebElement parentDiv = driver.findElement(By.className("_1Us3XD"));

        Actions actions = new Actions(driver);
        actions.moveToElement(parentDiv).perform();
        List<WebElement> ulElements = parentDiv.findElements(By.tagName("ul"));
        for (WebElement ul : ulElements) {
            List<WebElement> links = ul.findElements(By.tagName("a"));
            for (WebElement link : links) {
                if (link.getText().equals("Rewards")) {
                    link.click();
                    break;
                }
            }
        }
        String current_page=driver.getTitle();
	    String expected_page="Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com";
	    Assert.assertEquals(current_page, expected_page,"Not on the Product page");
        	
        	
    }
	
	
	public void Careers() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[contains(text(),'Careers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Life At Flipkart')]")).click();
		driver.findElement(By.xpath("//a[@id='candidate-login-before' and contains(text(),'Candidate Login')]")).click();
		String current_url=driver.getCurrentUrl();
		String url="https://www.flipkart.com/";
		Assert.assertNotEquals(current_url,url,"On the HomePage");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kartikeysharma992@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12344");
		driver.findElement(By.id("loginbtn")).click();
	}


	//Here we are performing the login opeartion
	//Since this functionality requires an OTP, so testing will throw assertion fail
	public void Login() {
		driver.findElement(By.xpath("//a[@title='Login' and @class='_1TOQfO']")).click();
		WebElement email_box=driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
		wait.until(ExpectedConditions.elementToBeClickable(email_box));
		email_box.sendKeys("9919520904");
		Assert.fail("Login operation failed");
	}
	
	//here we are checking the signing testing
	public void Signup() {
		driver.findElement(By.xpath("//a[@title='Login' and @class='_1TOQfO']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New to Flipkart? Create an account')]")).click();
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("9918520901");
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, "https://www.flipkart.com/","Login operation not performed successfully");
		
	}

	
	public void Shopsy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[contains(text(),'Shopsy')]")).click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size()>1) {
        	driver.switchTo().window(tabs.get(1));
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.click();
            searchBox.sendKeys("T-Shirt");
            searchBox.submit();
            String current_title=driver.getTitle();
            String expected_title="Shop Online for Mens & Womens Fashion, Beauty, Home, & More | Shopsy";
            Assert.assertEquals(current_title, expected_title,"Not on the Shopsy site");
        }else {
        	Assert.fail("New Tab not opened");
        }
	}

	
	public void Corporate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[contains(text(),'Flipkart Group')]")).click();
		driver.findElement(By.xpath("//a[@href='https://www.anscommerce.com/']")).click();
		String current_title=driver.getTitle();
		String expected_title="Flipkart Corporate Website";
		Assert.assertEquals(current_title, expected_title,"Not on Corporate Site");
	}
}
