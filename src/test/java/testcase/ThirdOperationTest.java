package testcase;

import org.testng.annotations.Test;
import pages.ThirdOperationPage;
import utility.DataProviderUtil;

public class ThirdOperationTest extends BaseTest {
	
	ThirdOperationPage repo;
	
	@Test(groups={"regression"},priority=1,dataProvider="detail",dataProviderClass=DataProviderUtil.class)
	public void Advertise(String name,String email, String mobile, String password) {
		if(testExecutionInfo.containsKey("Advertise")) {
			logger.info("Testing the Advertising  operation");
			repo=new ThirdOperationPage(driver);
			repo.Advertise(name,email,mobile,password);
			logger.info("Testing of Advertising operation done");
		}
		else {
			logger.error("Advertise is not activated");
		}
	}
	
	@Test(groups={"regression"},priority=2)
	public void Furniture() {
		if(testExecutionInfo.containsKey("Furniture")) {
			logger.info("Testing the Furniture  operation");
			repo=new ThirdOperationPage(driver);
			repo.Furniture();
			logger.info("Testing of Furniture operation done");
		}
		else {
			logger.error("Furniture is not activated");
		}
			
	}
	
	@Test(groups={"regression"},priority=3)
	public void GiftCard() {
		if(testExecutionInfo.containsKey("GiftCard")) {
			logger.info("Testing the Gift Card  operation");
			repo=new ThirdOperationPage(driver);
			repo.GiftCards();
			logger.info("Testing of Gift Card operation done");
		}
		else {
			logger.error("Gift Card is not activated");
		}
	}
	
	@Test(groups={"regression"},priority=4,dataProvider="detail",dataProviderClass=DataProviderUtil.class)
	public void GiftCardPersonal(String name,String email, String mobile, String password) {
		if(testExecutionInfo.containsKey("GiftCardPersonal")) {
			logger.info("Testing the Gift Card Failure  operation");
			repo=new ThirdOperationPage(driver);
			repo.GiftCardPersonalrequirements(name,email,mobile,password);
			logger.info("Testing of Gift Card Failure operation done");
		}
		else {
			logger.error("GiftCardPersonal is not activated");
		}
	}
	
	@Test(groups={"regression"},priority=5,dataProvider="mobiledata",dataProviderClass=DataProviderUtil.class)
	public void Cart(String mobile) {
		if(testExecutionInfo.containsKey("Cart")) {
			logger.info("Testing the Checking  operation");
			repo=new ThirdOperationPage(driver);
			repo.Checking_Cart(mobile);
			logger.info("Testing of Checking operation done");
		}
		else {
			logger.error("Cart is not activated");
		}
		
	}
	
	@Test(groups={"regression"},priority=6)
	public void Travel() {
		if(testExecutionInfo.containsKey("Travel")) {
			logger.info("Testing the Travel  operation");
			repo=new ThirdOperationPage(driver);
			repo.Travel();
			logger.info("Testing of Travel operation done");
		}
		else {
			logger.error("Travel is not activated");
		}
	}
}
