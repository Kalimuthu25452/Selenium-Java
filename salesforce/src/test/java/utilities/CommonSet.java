package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonSet {

	private WebDriver driver = null;
	
	public CommonSet(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean setText(By locator, String inputValue){
		driver.findElement(locator).sendKeys(inputValue);
		return true;
	}
}
