package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.SkipException;
import org.testng.annotations.*;
import utility.DriverConfiguration;
import utility.ReadExcelData;
import utility.ReadPropertyFile;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Method;
import java.time.Duration;


public class BaseTest {
	WebDriver driver;
	public static Logger logger;
	String url;
	DriverConfiguration driverConfig;
	public ReadPropertyFile prop;
	ReadExcelData excelData = new ReadExcelData();
    Map<String, String> testExecutionInfo;
	
	static {
        System.setProperty("log4j.configurationFile", "src/test/resources/configfiles/log4j2.properties");
    }
	
	
	public boolean isActive(String methodName) {
	    testExecutionInfo = excelData.testExecutionInfo();
	    if (!testExecutionInfo.containsKey(methodName)) {
	        logger.info("Test operation is not active for the " + methodName);
	        return false;
	    }
	    
	    return true;
	}
	
	@BeforeClass
	public void setUp_Configurations() {
		logger = LogManager.getLogger("ExitTest");
//		driverConfig = new DriverConfiguration();
//	    prop = new ReadPropertyFile();
//	    prop.configuration();
//	    driver = driverConfig.getDriver();
//	    logger.info("Driver is set up");
//	    url = prop.getUrl();
//	    driver.get(url);
//	    logger.info("Website Opened");
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	    driver.manage().window().maximize();
	}
		
	@BeforeMethod()
	public void setup(Method method) {
	    String methodName = method.getName();
	    testExecutionInfo = excelData.testExecutionInfo();
	    if (!isActive(methodName)) {
            return;
        }

	    driverConfig = new DriverConfiguration();
	    prop = new ReadPropertyFile();
	    prop.configuration();
	    driver = driverConfig.getDriver();
	    logger.info("Driver is set up");
	    url = prop.getUrl();
	    driver.get(url);
	    logger.info("Website Opened");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	}
	
//	@BeforeMethod
//	public void setup(Method method) {
//        String methodName = method.getName();
//        if (!isActive(methodName)) {
//            throw new SkipException("Skipping this test as the testExecution is not active: " + methodName);
//        }
//
//        if (driver == null) {
//            driver = driverConfig.getDriver();
//            logger.info("Driver is set up");
//            driver.get(url);
//            logger.info("Website Opened");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//            driver.manage().window().maximize();
//        }
//    }
	
	@AfterMethod
	public void tearDownTest() {
		try {
	        if (driver != null) {
	            driver.quit();
	            logger.info("quitting the driver");
	        }
	    } catch (NullPointerException e) {
	        logger.warn("NullPointerException occurred while attempting to quit the driver: " + e.getMessage());
	    } catch (Exception e) {
	        logger.error("An unexpected error occurred while quitting the driver: " + e.getMessage());
	    }
	}
	
	@AfterClass
	public void tearDownClass() {
		try {
	        if (driver != null) {
	            driver.quit();
	            logger.info("quitting the driver");
	        }
	    } catch (NullPointerException e) {
	        logger.warn("NullPointerException occurred while attempting to quit the driver: " + e.getMessage());
	    } catch (Exception e) {
	        logger.error("An unexpected error occurred while quitting the driver: " + e.getMessage());
	    }
	}
	
	
}
