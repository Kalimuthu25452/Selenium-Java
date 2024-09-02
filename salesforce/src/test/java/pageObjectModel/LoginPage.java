package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseListerner;
import utilities.CommonActions;
import utilities.CommonSet;
import utilities.CommonWaits;

public class LoginPage extends BaseListerner {

// Initialization
	private WebDriver driver = null;
	private CommonSet commonSet;
	
// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		commonSet = new CommonSet(driver);
	}

// Locators
	private By loginIdXpath = By.xpath(prop_locators.getProperty("ip_LoginId_Xpath"));
	private By loginPasswordXpath = By.xpath(prop_locators.getProperty("ip_Password_Xpath"));
	private By loginButtonXpath = By.xpath(prop_locators.getProperty("btn_Login_Xpath"));

// ENTER USERNAME
	@Test
	public boolean enterUserName() throws InterruptedException {
		// Wait for element visibility
		
		// Non Static Classes - for calling Common methods
		CommonWaits commonWait = new CommonWaits(driver);
		commonWait.waitForElementVisibility(loginIdXpath, 15);
		
		// Set Login Id
		boolean isSetTextCompleted = commonSet.setText(loginIdXpath, prop_inputs.getProperty("userName"));
		
		return isSetTextCompleted;
	}

// ENTER PASSWORD
	@Test
	public boolean enterPassword() {
		// Set Login Id
		//CommonSet commonSet = new CommonSet(driver);
		boolean isSetTextCompleted = commonSet.setText(loginPasswordXpath, prop_inputs.getProperty("password"));
		
		return isSetTextCompleted;
	}

// CLICK LOGIN
	@Test
	public boolean clickLoginButton() {
		CommonActions commonActions = new CommonActions(driver);
		boolean isClicked = commonActions.click(loginButtonXpath);
		
		return isClicked;
	}
}
