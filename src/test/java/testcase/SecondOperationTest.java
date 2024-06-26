package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FirstOpeartionPage;
import pages.SecondOperationPage;
import utility.DataProviderUtil;

public class SecondOperationTest extends BaseTest {
	
	SecondOperationPage repo;
	
	@Test(groups={"smoke"},priority=1,enabled=true)
	public void Electronics() {
		if(testExecutionInfo.containsKey("Electronics")) {
			logger.info("Electronics Testing is being performed");
			repo= new SecondOperationPage(driver);
			repo.Electronics();
			logger.info("Electronics testing is completed");
		}
		else {
			logger.error("Electronics is not activated");
			Assert.fail("Electronics is not activated");
		}
	}
	
	@Test(groups={"smoke"},priority=2,enabled=true)
	public void Rewards() {
		if(testExecutionInfo.containsKey("Rewards")) {
			logger.info("Rewards Testing is being performed");
			repo= new SecondOperationPage(driver);
			repo.Reward();
			logger.info("Rewards testing is completed");
		}
		else {
			logger.error("Rewards is not activated");
			Assert.fail("Rewards is not activated");
		}
	}
	@Test(groups={"regression"},priority=3,dataProvider="credentials", dataProviderClass=DataProviderUtil.class,enabled=true)
	public void Careers(String email,String password) {
		if(testExecutionInfo.containsKey("Careers")) {
			logger.info("Checking footer Careers section");
			repo=new SecondOperationPage(driver);
			repo.Careers(email,password);
			logger.info("Careers section testing done");
		}
		else {
			logger.error("Careers is not activated");
			Assert.fail("Careers is not activated");
		}
	}
	@Test(groups={"regression"},priority=4,dataProvider="mobiledata",dataProviderClass=DataProviderUtil.class,enabled=true)
	public void Login(String mobile) {
		if(testExecutionInfo.containsKey("Login")) {
			logger.info("Testing the login operation");
			repo=new SecondOperationPage(driver);
			repo.Login(mobile);
			logger.info("Testing of login operation done");
		}
		else {
			logger.error("Login is not activated");
			Assert.fail("Login is not activated");
		}
	}	
	@Test(groups={"smoke"},priority=5,dataProvider="mobiledata",dataProviderClass=DataProviderUtil.class,enabled=true)
	public void Signup(String mobile) {
		if(testExecutionInfo.containsKey("Signup")) 
		{
			logger.info("Testing the signup operation");
			repo=new SecondOperationPage(driver);			repo.Signup(mobile);
			logger.info("Testing of signup operation done");
		}
		else {
			logger.error("Signup is not activated");
			Assert.fail("Signup is not activated");
		}
	}
	
	@Test(groups={"smoke"},priority=6,enabled=true)
	public void Shopsy() {
		if(testExecutionInfo.containsKey("Shopsy")) {
			logger.info("Testing the shopsy site operation");
			repo=new SecondOperationPage(driver);
			repo.Shopsy();
			logger.info("Testing of shopsy site operation done");
		}
		else {
			logger.error("Shopsy is not activated");
			Assert.fail("Shopsy is not activated");
		}
	}
	
	@Test(groups={"smoke"},priority=7,enabled=true)
	public void CorporateWebsite() {
		if(testExecutionInfo.containsKey("CorporateWebsite")) {
			logger.info("Testing the corporate website operation");
			repo=new SecondOperationPage(driver);
			repo.Corporate();
			logger.info("Testing of corporate website operation done");
		}
		else {
			logger.error("Corporate Website is not activated");
			Assert.fail("Corporate Website is not activated");
		}
	}
}
