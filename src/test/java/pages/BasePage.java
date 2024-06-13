package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ReadPropertyFile;

public class BasePage {
	
	WebDriver driver;
	public String base_url=ReadPropertyFile.getUrl();
	public int wait_time=ReadPropertyFile.getWaitTime();
	WebDriverWait wait ;
}
