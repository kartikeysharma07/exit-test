package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfiguration {
	
	public WebDriver driver;
	public ReadPropertyFile prop;
	
	public DriverConfiguration() {
		prop= new ReadPropertyFile();
		prop.configuration();
		setupDriver();
	}
	
	private void setupDriver() {
		String browser = prop.getBrowser();
        boolean headlessProp = prop.getHeadlessInfo();
        
        if(browser.equalsIgnoreCase("chrome")) {

			if(headlessProp) {
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--headless=new");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(opt);
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			
		}else if(browser.equalsIgnoreCase("edge")) {
			if(headlessProp) {
				EdgeOptions opt=new EdgeOptions();
				opt.addArguments("--headless=new");
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver(opt);
			}
			else {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			}
		}
	}

	public WebDriver getDriver() {
        return driver;
    }
}

