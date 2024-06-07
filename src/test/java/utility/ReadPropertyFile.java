package utility;

import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFile {
	
	public String url;
	public String browser;
	public int waitTime;
	public boolean headlessProp;

	public void configuration() {
		String relativePath = "src/test/resources/configfiles/config.properties";
        String absolutePath = System.getProperty("user.dir") + "/" + relativePath;
		try {
			
	    	FileReader file = new FileReader(absolutePath);
	    	Properties prop= new Properties();
	    	prop.load(file);
	    	
	    	url= prop.getProperty("testurl");
	    	waitTime=Integer.parseInt(prop.getProperty("waittime"));
			browser=prop.getProperty("browser");
			headlessProp = Boolean.parseBoolean(prop.getProperty("headless"));
	    	
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	}
	
	
	public String getUrl() {
		return url;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public Boolean getHeadlessInfo() {
		return headlessProp;
	}
}
