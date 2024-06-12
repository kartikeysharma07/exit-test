package testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DataProviderUtil;
import utility.ReadExcelData;
import pages.FirstOpeartionPage;

public class FirstOpeartionTest extends BaseTest {
	
	FirstOpeartionPage repo;
	@Test(dataProvider="searchdata", dataProviderClass=DataProviderUtil.class,groups={"smoke", "regression"},priority=1)
	public void search(String item,String model) {
		if(testExecutionInfo.containsKey("search")) {
			logger.info("Search is being performed");
			repo= new FirstOpeartionPage(driver);
			repo.Search(item,model);
			logger.info("Search is completed");
		}
		else {
			logger.error("Searching is not activated");
		}
	}	
	
	@Test(dataProvider="grocerydata", dataProviderClass=DataProviderUtil.class,groups={"smoke", "regression"},priority=2)
	public void grocery(String pincode,String item) {
		if(testExecutionInfo.containsKey("grocery")) {
			logger.info("Grocery Testing is being performed");
			repo= new FirstOpeartionPage(driver);
			repo.Grocery(pincode,item);
			logger.info("Grocery testing is completed");
		}
		else {
			logger.error("Grocery is not activated");
		}
	}
	
	@Test(groups={"smoke", "regression"},priority=3)
	public void specficProduct()
	{
		if(testExecutionInfo.containsKey("specificProduct")) {
			logger.info("Performing add to item testing opeartion");
			repo=new FirstOpeartionPage(driver);
			repo.SpecficProduct();
			logger.info("Add to cart performed successfully");
		}
		else {
			logger.error("Specific Product is not activated");
		}
	}
	
	@Test(dataProvider="sellerdata",dataProviderClass=DataProviderUtil.class,priority=4,groups={"smoke", "regression"})
	public void becomeSeller(String mobile,String email) {
		if(testExecutionInfo.containsKey("becomeSeller")) {
			logger.info("Performing become a seller testigng");
			repo=new FirstOpeartionPage(driver);
			repo.BecomeSeller(mobile,email);
			logger.info("Seller testing completed");
		}
		else {
			logger.error("Become seller is not activated");
		}
	}
	
	@Test(dataProvider="fashiondata",dataProviderClass=DataProviderUtil.class,groups={"smoke", "regression"},priority=5)
	public void fashion(String section,String product) {
		if(testExecutionInfo.containsKey("fashion")) {
			logger.info("Performing the Fashion testing");
			repo=new FirstOpeartionPage(driver);
			repo.Fashion(section,product);
			logger.info("Fashion testing done");
		}
		else {
			logger.error("Fashion is not activated");
		}
	}
	
	@Test(groups={"smoke", "regression"},priority=6)
	public void notification() {
		if(testExecutionInfo.containsKey("notification")) {
			logger.info("Checking the notification opeartion");
			repo=new FirstOpeartionPage(driver);
			repo.Notifications();
			logger.info("Notification opeartion checking done");
		}
		else {
			logger.error("Notification is not activated");
		}
	}
	
	@Test(groups={"smoke", "regression"},priority=7)
	public void twowheeler() {
		if(testExecutionInfo.containsKey("twowheeler")) {
			logger.info("Checking the Two Wheeler opeartion");
			repo=new FirstOpeartionPage(driver);
			repo.TwoWheeler();
			logger.info("Two Wheeler opeartion checking done");
		}
		else {
			logger.error("Two Wheeler is not activated");
		}
	}
}
