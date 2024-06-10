package testcase;

import org.testng.annotations.Test;

import pages.FirstOpeartionPage;
import pages.SecondOperationPage;

public class SecondOperationTest extends BaseTest {
	
	SecondOperationPage repo;
	
	@Test
	public void Electronics() {
		logger.info("Electronics Testing is being performed");
		repo= new SecondOperationPage(driver);
		repo.Electronics();
		logger.info("Electronics testing is completed");
	}
}
