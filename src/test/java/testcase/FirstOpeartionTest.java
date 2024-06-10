package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DataProviderUtil;
import pages.FirstOpeartionPage;

public class FirstOpeartionTest extends BaseTest {
	
	FirstOpeartionPage repo;
	@Test(dataProvider="searchdata", dataProviderClass=DataProviderUtil.class)
	public void search(String item,String model) {
		logger.info("Search is being performed");
		repo= new FirstOpeartionPage(driver);
		repo.Search(item,model);
		logger.info("Search is completed");
	}	
	
	@Test(dataProvider="grocerydata", dataProviderClass=DataProviderUtil.class)
	public void grocery(String pincode,String item) {
		logger.info("Grocery Testing is being performed");
		repo= new FirstOpeartionPage(driver);
		repo.Grocery(pincode,item);
		logger.info("Grocery testing is completed");
	}
	
//	@Test()
//	public void addtocart()
//	{
//		logger.info("Performing add to item testing opeartion");
//		repo=new FirstOpeartionPage(driver);
//		repo.AddToCart();
//		logger.info("Add to cart performed successfully");
//	}
	
	@Test(dataProvider="sellerdata",dataProviderClass=DataProviderUtil.class)
	public void becomeSeller(String mobile,String email) {
		logger.info("Performing become a seller testigng");
		repo=new FirstOpeartionPage(driver);
		repo.BecomeSeller(mobile,email);
		logger.info("Seller testing completed");
	}
	
	@Test(dataProvider="fashiondata",dataProviderClass=DataProviderUtil.class)
	public void fashion(String section,String product) {
		logger.info("Performing the Fashion testing");
		repo=new FirstOpeartionPage(driver);
		repo.Fashion(section,product);
		logger.info("Fashion testing done");
	}
	
	@Test()
	public void notification() {
		logger.info("Checking the notification opeartion");
		repo=new FirstOpeartionPage(driver);
		repo.Notifications();
		logger.info("Notification opeartion checking done");
	}
	
	@Test()
	public void twowheeler() {
		logger.info("Checking the Two Wheeler opeartion");
		repo=new FirstOpeartionPage(driver);
		repo.TwoWheeler();
		logger.info("Two Wheeler opeartion checking done");
	}
}
