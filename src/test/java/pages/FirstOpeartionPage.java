package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FirstOpeartionPage extends BasePage {
	
	WebElement search_box;
	
	public FirstOpeartionPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//this opeartion will search the product in the website
	public void Search(String query) {
		search_box=findElement("//input[@name='q']");
		search_box.sendKeys(query);
		search_box.submit();
	}
	
}
