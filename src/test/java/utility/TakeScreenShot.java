package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot extends DriverConfiguration{
	public String getScreenshot() {
		WebDriver driver= getDriver();
		TakesScreenshot takescreenshot= ((TakesScreenshot) driver);
		String src= takescreenshot.getScreenshotAs(OutputType.BASE64);
		return src;

	}
}
