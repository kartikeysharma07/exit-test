package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass extends TakeScreenShot  implements ITestListener{
	ExtentSparkReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		System.out.println("The extent is working");
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "RestAssuredTestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter("C:\\Users\\kartikeysharma\\Automation_QA\\ExitTestFinal\\src\\test\\resources\\reports\\"+ reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("This is the extent report on Trello API");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	public void onStart(ITestContext Result)					
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}	

	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();

	}		
		

	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed From Extent Report:" + Result.getName() );  		
		test = reports.createTest(Result.getName());
		String path=getScreenshot();
		test.info("The is for the test :"+ Result.getName())
		.addScreenCaptureFromBase64String(path);
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
		test.fail(Result.getThrowable());
	}
		
	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.info("The is for the test :"+ Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started From Extent Report:" + Result.getName() );  		

	}		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.info("The is for the test :"+ Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}
	
}
