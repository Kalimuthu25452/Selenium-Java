package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWaits {

	static WebDriver driver = null;
	
	// 'Constructor'
	public CommonWaits(WebDriver driver) {
		CommonWaits.driver = driver;
	}
	
	/*
	 *  WAIT FOR ELEMENT VISIBITILY
	 *  @Param By xpath - xpath of the element with By
	 *  @Param int timeout
	 *  
	 *  @return boolean
	 */
	public boolean waitForElementVisibility(By locator, int timeout) {
		// 'Wait for element visibility'
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
		
		var success = true;
		
		return success;
	}
}
