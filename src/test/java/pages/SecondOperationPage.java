package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondOperationPage extends BasePage {
	
	WebDriverWait wait ;
	public SecondOperationPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void Electronics() {
		WebElement electronics_link=driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		electronics_link.click();
		driver.findElement(By.xpath("//a[contains(text(),'Bluetooth Headphones')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
	}
}
