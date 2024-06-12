package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfiguration {
	
	public WebDriver driver;
	public ReadPropertyFile prop=new ReadPropertyFile();
	
	public DriverConfiguration() {
	}
	
	private void setupDriver() {
		prop.configuration();
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
        
        if (driver == null) {
            throw new RuntimeException("Failed to initialize WebDriver for browser: " + browser);
        }
	}

	public WebDriver getDriver() {
		if (driver == null) {
            setupDriver();
        }
        return driver;
    }
}

