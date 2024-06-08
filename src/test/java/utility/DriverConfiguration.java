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
        System.out.println(((Object) prop.getHeadlessInfo()).getClass().getName());
        
        if(browser.equalsIgnoreCase("chrome")) {
        	ChromeOptions opt=new ChromeOptions();
        	opt.addArguments("--no-sandbox");
            opt.addArguments("--disable-dev-shm-usage");
			if(headlessProp) {
				opt.addArguments("--headless=new");
			}
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(opt);
			
		}else if(browser.equalsIgnoreCase("edge")) {
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--no-sandbox");
            opt.addArguments("--disable-dev-shm-usage");
			if(headlessProp) {
				opt.addArguments("--headless=new");
			}
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver(opt);
		}
        
        if (driver == null) {
            throw new RuntimeException("Failed to initialize WebDriver for browser: " + browser);
        }
	}

	public WebDriver getDriver() {
        return driver;
    }
}

