package utility;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

//PropertyReader Class that will provide the file location path for different data files and configuartion file.
public class FileLocationReader {
	private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/configfiles/fileLocation.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getReportPath() {
        return properties.getProperty("REPORT_PATH");
    }
    
    public static String getConfigPath() {
    	return properties.getProperty("CONFIG_PATH");
    }
    
    public static String getLogPath() {
    	return properties.getProperty("LOG_PATH");
    }
    
    public static String getExcelPath() {
    	return properties.getProperty("EXCEL_PATH");
    }
}
