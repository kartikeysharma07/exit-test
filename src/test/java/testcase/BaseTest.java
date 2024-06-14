package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utility.DriverConfiguration;
import utility.FileLocationReader;
import utility.ReadExcelData;
import utility.ReadPropertyFile;
import utility.TakeScreenShot;
import java.util.Date;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;


public class BaseTest {
	WebDriver driver;
	public static Logger logger;
	String url;
	DriverConfiguration driverConfig=new DriverConfiguration();
	public ReadPropertyFile prop;
	static  Map<String, String> testExecutionInfo;
    public int wait_time=ReadPropertyFile.getWaitTime();
    ExtentSparkReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	static String LogPath=System.getProperty("user.dir")+ File.separator + FileLocationReader.getLogPath();
	
	static {
        System.setProperty("log4j.configurationFile", LogPath);
    }
	

	//this method checks before every method execution that whether the test is activated or not.
	//it checks that given method is present in the hashmap? If it is then the method is marked active in the 
	//Main Tests File.
	public boolean isActive(String methodName) {
//	    if (!testExecutionInfo.containsKey(methodName)) {
//	        logger.error("Test operation is not active for the " + methodName);
//	        return false;
//	    }
//	    
//	    return true;
		
		if (testExecutionInfo == null || !testExecutionInfo.containsKey(methodName)) {
            logger.error("Test operation is not active for the " + methodName);
            return false;
        }
        return true;
	}
	
	//In the before class we are setting up the extent report that will generated per class.
	@BeforeClass
	public void setUp_Configurations() {
		logger = LogManager.getLogger("ExitTest");
		testExecutionInfo = ReadExcelData.testExecutionInfo();
		logger.info("The extent is working");
		String timestamp = new SimpleDateFormat("yyyy.mm.dd-hh.mm.ss").format(new Date());
		String reportName = "TestReport-" + timestamp + ".html";
		String reportPath = System.getProperty("user.dir")+ File.separator + FileLocationReader.getReportPath();
		htmlReporter = new ExtentSparkReporter(reportPath+ reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	@AfterClass()
	public void tearDownExtentReports() {
        if (reports != null) {
            reports.flush();
        }
    } 
	@BeforeMethod()
	public void setup(Method method) {
	    String methodName = method.getName();
	    if (!isActive(methodName)) {
            return;
        }
	    driverConfig=new DriverConfiguration();
	    driver=driverConfig.getDriver();
	    logger.info("Driver is set up");
	    url=ReadPropertyFile.getUrl();
	    driver.get(url);
	    logger.info("Website Opened");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_time));
	    driver.manage().window().maximize();
	}
	
	//Here after the completion of the method we are  generating the report and clicking the screenshot in case
	//of test failure.
	@AfterMethod
	public void tearDownTest(ITestResult Result,Method method) {		
		if(driver!=null) {
			if(Result.getStatus()==ITestResult.FAILURE) {
				logger.error("Name of test method failed From Extent Report:" + Result.getName());  		
				test = reports.createTest(Result.getName());
				String path=TakeScreenShot.getScreenshot(driver, Result.getName());
				logger.info("Taking screenshot of the case");
				test.info("The is for the test :"+ Result.getName())
				.addScreenCaptureFromPath(path);
				test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
				test.fail(Result.getThrowable());
			}else if(Result.getStatus()==ITestResult.SUCCESS) {
				logger.info("Name of test method sucessfully executed:" + Result.getName());
				test = reports.createTest(Result.getName());
				test.info("The is for the test :"+ Result.getName());
				test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
			}else if(Result.getStatus()==ITestResult.SKIP){
				logger.warn("Name of test method skipped:" + Result.getName() );  		
				test = reports.createTest(Result.getName());
				test.info("The is for the test :"+ Result.getName());
				test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
			}
			driver.quit();
			logger.info("quitting the driver");
		}
	}

	
	
}

