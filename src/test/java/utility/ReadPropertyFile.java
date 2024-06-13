package utility;

import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFile {
    
    private static String url;
    private static String browser;
    private static int waitTime;
    private static boolean headlessProp;

    static {
        configuration();
    }

    private static void configuration() {
        String relativePath = "src/test/resources/configfiles/config.properties";
        String absolutePath = System.getProperty("user.dir") + "/" + relativePath;
        try {
            FileReader file = new FileReader(absolutePath);
            Properties prop = new Properties();
            prop.load(file);
            
            url = prop.getProperty("testurl");
            waitTime = Integer.parseInt(prop.getProperty("waittime"));
            browser = prop.getProperty("browser");
            headlessProp = Boolean.parseBoolean(prop.getProperty("headless"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static String getUrl() {
        return url;
    }
    
    public static int getWaitTime() {
        return waitTime;
    }
    
    public static String getBrowser() {
        return browser;
    }
    
    public static Boolean getHeadlessInfo() {
        return headlessProp;
    }
}
