package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverConfiguration {
	
	public WebDriver driver;
	
	public DriverConfiguration() {
	}
	
	private void setupDriver() {
		String browser=ReadPropertyFile.getBrowser();
		boolean headlessProp=ReadPropertyFile.getHeadlessInfo();
        
        if(browser.equalsIgnoreCase("chrome")) {
			if(headlessProp) {
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--headless=new");
				driver=new ChromeDriver(opt);
			}
			else {
				driver=new ChromeDriver();
			}
			
		}else if(browser.equalsIgnoreCase("edge")) {
			if(headlessProp) {
				EdgeOptions opt=new EdgeOptions();
				opt.addArguments("--headless=new");
				driver= new EdgeDriver(opt);
			}
			else {
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

