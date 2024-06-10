package utility;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	ReadExcelData excelData=new ReadExcelData();
	
	@DataProvider(name="searchdata")
	public Object[][] searchData() {
        return excelData.getData("products");
    }
	
	@DataProvider(name="grocerydata")
	public Object[][] groceryData(){
		return excelData.getData("grocery");
	}
	@DataProvider(name="sellerdata")
	public Object[][] sellerData(){
		return excelData.getData("seller");
	}
	@DataProvider(name="fashiondata")
	public Object[][] fashionData(){
		return excelData.getData("fashion");
	}
}
