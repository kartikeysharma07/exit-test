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
	
	@DataProvider(name="credentials")
	public Object[][] signinCredentials(){
		Object[][] data = ReadExcelData.getData("Details");
        Object[][] credentialsData = new Object[data.length][2];
        
        for (int i = 0; i < data.length; i++) {
            credentialsData[i][0] = data[i][1];
            credentialsData[i][1] = data[i][3];
        }
        return credentialsData;
	}
	@DataProvider(name="mobiledata")
	public Object[][] mobile(){
		Object[][] data = ReadExcelData.getData("Details");
		Object[][] credentialsData = new Object[data.length][1];
		for (int i = 0; i < data.length; i++) {
            credentialsData[i][0] = data[i][2];
        }
        return credentialsData;
	}
	@DataProvider(name="detail")
	public Object[][] userDetails(){
		Object[][] data = ReadExcelData.getData("Details");
		Object[][] credentialsData = new Object[data.length][4];
		
		for(int i=0;i<data.length;i++) {
			credentialsData[i][0] = data[i][0];
            credentialsData[i][1] = data[i][1];
            credentialsData[i][2] = data[i][2];
            credentialsData[i][3] = data[i][3];
		}
		
		return credentialsData;
	}
}
