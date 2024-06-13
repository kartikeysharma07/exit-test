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

import locators.SecondLocators;
import utility.AssertionClass;

public class SecondOperationPage extends BasePage {
	
	WebDriverWait wait ;
	public SecondOperationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void Electronics() {
		WebElement electronics_link=driver.findElement(By.xpath(SecondLocators.ELECTRONICS_LINK));
		electronics_link.click();
		driver.findElement(By.xpath(SecondLocators.SECTION)).click();
		driver.findElement(By.xpath(SecondLocators.ITEM)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String current_page_url=driver.getCurrentUrl();
        String url=base_url;
        Assert.assertNotEquals(current_page_url, url,AssertionClass.HOME_ERROR_MESSAGE);
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
	    String expected_page=AssertionClass.HOMETITLE;
	    Assert.assertEquals(current_page, expected_page,AssertionClass.PRODUCT_ERROR_MESSAGE);
        	
        	
    }
	
	
	public void Careers() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(SecondLocators.CAREER_LINK)).click();
		driver.findElement(By.xpath(SecondLocators.FLIPKART_LINK)).click();
		driver.findElement(By.xpath(SecondLocators.CANDIDATE_LOGIN)).click();
		String current_url=driver.getCurrentUrl();
		String url=base_url;
		Assert.assertNotEquals(current_url,url,"On the HomePage");
		driver.findElement(By.xpath(SecondLocators.USER_INPUT)).sendKeys("kartikeysharma992@gmail.com");
		driver.findElement(By.xpath(SecondLocators.USER_PASSWORD)).sendKeys("12344");
		driver.findElement(By.id(SecondLocators.USER_LOGIN)).click();
	}


	//Here we are performing the login opeartion
	//Since this functionality requires an OTP, so testing will throw assertion fail
	public void Login() {
		driver.findElement(By.xpath(SecondLocators.LOGIN_BUTTON)).click();
		WebElement email_box=driver.findElement(By.xpath(SecondLocators.EMAIL_LOGIN));
		wait.until(ExpectedConditions.elementToBeClickable(email_box));
		email_box.sendKeys("9919520904");
		Assert.fail(AssertionClass.LOGIN_SIGNUP_ERROR_FAILED);
	}
	
	//here we are checking the signing testing
	public void Signup() {
		driver.findElement(By.xpath(SecondLocators.LOGIN_BUTTON)).click();
		driver.findElement(By.xpath(SecondLocators.CREATE_ACCOUNT)).click();
		driver.findElement(By.xpath(SecondLocators.EMAIL_LOGIN)).sendKeys("9918520901");
		String current_url=driver.getCurrentUrl();
		String url=base_url;
		Assert.assertEquals(current_url, url,AssertionClass.LOGIN_SIGNUP_ERROR_FAILED);
		
	}

	
	public void Shopsy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(SecondLocators.SHOPSY_LINK)).click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size()>1) {
        	driver.switchTo().window(tabs.get(1));
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.click();
            searchBox.sendKeys("T-Shirt");
            searchBox.submit();
            String current_title=driver.getTitle();
            String expected_title=AssertionClass.SHOPSYTITLE;
            Assert.assertEquals(current_title, expected_title,AssertionClass.PAGE_ERROR_MESSAGE);
        }else {
        	Assert.fail(AssertionClass.TAB_ERROR_MESSAGE);
        }
	}

	
	public void Corporate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(SecondLocators.ABOUTUS)).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(SecondLocators.FLIPKART_GROUP)).click();
		String current_title=driver.getTitle();
		String expected_title=AssertionClass.CORPORATETITLE;
		Assert.assertEquals(current_title, expected_title,AssertionClass.PAGE_ERROR_MESSAGE);
	}
}
