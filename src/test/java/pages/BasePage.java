package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	WebDriver driver;
	
	public WebElement findElement(String locator) {
		return driver.findElement(By.xpath("//input[@name='q']"));
	}
}
