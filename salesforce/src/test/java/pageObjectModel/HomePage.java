package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseListerner;
import utilities.CommonWaits;

public class HomePage extends BaseListerner{

// Initialization
	private WebDriver driver;
	
// Locators
	static By mainMenuList_Xpath = By.xpath(prop_locators.getProperty("listOfMenus_Xpath"));

// Get Expected page title from input file
	String expected_HomePageTitle = prop_inputs.getProperty("homePageTitle");

// Constructor
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	@Test
	public boolean waitForHomePageLoad(int timeoutInSeconds) {

		CommonWaits commonWait = new CommonWaits(driver);
		boolean isMenuVisible = commonWait.waitForElementVisibility(mainMenuList_Xpath, timeoutInSeconds);
		
		return isMenuVisible;
	}
	
	@Test
	public boolean verifyHomePageTitle() {

		String actual_HomePageTitle = driver.getTitle();
		boolean isEqual = expected_HomePageTitle.equals(actual_HomePageTitle);

		return isEqual;
	}
}
