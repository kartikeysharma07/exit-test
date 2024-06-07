package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import utility.DriverConfiguration;
import utility.ReadPropertyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
	WebDriver driver;
	public static Logger logger;
	String url;
	DriverConfiguration driverConfig;
	public ReadPropertyFile prop;
	
	static {
        System.setProperty("log4j.configurationFile", "src/test/resources/configfiles/log4j2.properties");
    }
	
	@BeforeClass
	public void setUp_Logger() {
		logger = LogManager.getLogger("ExitTest");
	}
	
	@BeforeMethod()
	public void setup() {
		driverConfig=new DriverConfiguration();
		prop= new ReadPropertyFile();
		prop.configuration();
		driver=driverConfig.getDriver();
		logger.info("Driver is set up");
		url=prop.getUrl();
		driver.get(url);
		logger.info("Website Opened");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterTest() {
		driver.close();
		logger.info("quitting the driver");
	}
}
