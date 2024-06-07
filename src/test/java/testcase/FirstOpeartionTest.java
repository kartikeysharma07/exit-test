package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DataProviderUtil;
import pages.FirstOpeartionPage;

public class FirstOpeartionTest extends BaseTest {
	
	FirstOpeartionPage repo;
	@Test(dataProvider="searchdata", dataProviderClass=DataProviderUtil.class)
	public void search(String query) {
		repo= new FirstOpeartionPage(driver);
		repo.Search(query);
	}	
}
