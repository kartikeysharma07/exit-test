package utility;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
//	ReadExcelData excelData=new ReadExcelData();
	
	@DataProvider(name="searchdata")
	public Object[][] searchData() {
//        return excelData.getData("products");
        return ReadExcelData.getData("products");
    }
	
	@DataProvider(name="grocerydata")
	public Object[][] groceryData(){
//		return excelData.getData("grocery");
		return ReadExcelData.getData("grocery");
	}
	@DataProvider(name="sellerdata")
	public Object[][] sellerData(){
//		return excelData.getData("seller");
		return ReadExcelData.getData("seller");
	}
	@DataProvider(name="fashiondata")
	public Object[][] fashionData(){
//		return excelData.getData("fashion");
		return ReadExcelData.getData("fashion");
	}
}
