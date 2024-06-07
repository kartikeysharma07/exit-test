package utility;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	ReadExcelData excelData=new ReadExcelData();
	
	@DataProvider(name="searchdata")
	public Object[][] searchData() {
        return excelData.getData("products");
    }
}
