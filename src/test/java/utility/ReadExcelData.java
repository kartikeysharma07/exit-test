package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcelData {
	
	public Map<String,String>testExecutionInfo() {
		Map<String,String> testInfo=new HashMap<>();
		File file=new File("C:\\Users\\kartikeysharma\\Automation_QA\\ExitTestFinal\\src\\test\\resources\\testdata\\Data.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet=wb.getSheet("Tests");
			int totalRows=sheet.getLastRowNum();
			Row rowCells=sheet.getRow(0);
			int totalCols=rowCells.getLastCellNum();
			DataFormatter format = new DataFormatter();
			
			for(int i=1;i<=totalRows;i++) {
				Row row=sheet.getRow(i);
				String testName=format.formatCellValue(row.getCell(1));
				String testStatus=format.formatCellValue(row.getCell(2));
				String sheetName=format.formatCellValue(row.getCell(4));
				if (testStatus.equalsIgnoreCase("Yes")) {
                    testInfo.put(testName, sheetName.isEmpty() ? null : sheetName);
                }
				
			}
			
			return testInfo;
			
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
            return new HashMap<>();
		}
	}
	
	
	
	
	public String[][] getData(String excelSheetName) {
		File file=new File("C:\\Users\\kartikeysharma\\Automation_QA\\ExitTestFinal\\src\\test\\resources\\testdata\\Data.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheetName=wb.getSheet(excelSheetName);
			int totalRows=sheetName.getLastRowNum();
			Row rowCells=sheetName.getRow(0);
			int totalCols=rowCells.getLastCellNum();
			
			DataFormatter format = new DataFormatter();
			String testData[][]=new String[totalRows][totalCols];
			
			for(int i=1;i<=totalRows;i++) {
				for(int j=0;j<totalCols;j++) {
					testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				}
			}
			
			return testData;
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
			return new String[0][0];
		}
	}
	
	
}
