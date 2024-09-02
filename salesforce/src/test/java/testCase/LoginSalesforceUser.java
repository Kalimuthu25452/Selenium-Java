package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseListerner;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class LoginSalesforceUser extends BaseListerner {

	// public static WebDriver driver;
	
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		String reportLocation = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\LoginSalesforceUser.html";
				
		report = new ExtentReports(reportLocation);
		
		test = report.startTest("Login into Salesforce org");
	}

	@Test
	public static void LoginIntoWebsite() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		
		// Enter UserName
		test.log(LogStatus.INFO, "Enter Login Username");
		boolean isSetTextCompleted = loginPage.enterUserName();
		assertEquals(isSetTextCompleted, true);
		test.log(LogStatus.PASS, "Success: Set 'UserName' in respective field");

		// Enter Password
		test.log(LogStatus.INFO, "Enter Login Password");
		boolean isSetPasswordCompleted = loginPage.enterPassword();
		assertEquals(isSetPasswordCompleted, true);
		test.log(LogStatus.PASS, "Success: Set 'Password' in respective field");
		
		// Click Login button
		test.log(LogStatus.INFO, "Click Login button");
		boolean isClicked = loginPage.clickLoginButton();
		assertEquals(isClicked, true);
		test.log(LogStatus.PASS, "Success: Click Login button");

		// Wait for page to load
		int timeoutInSeconds = 30;
		test.log(LogStatus.INFO, "Wait for Home Page load");
		HomePage homePage = new HomePage(driver);
		boolean isMenuVisible = homePage.waitForHomePageLoad(timeoutInSeconds);
		assertEquals(isMenuVisible, true);	
		test.log(LogStatus.PASS, "Success: Wait until all the Elements load");
		
		// Verify Page Title - Home Page
		test.log(LogStatus.INFO, "Verify Page title");
		boolean isHomePageTitle = homePage.verifyHomePageTitle();
		assertEquals(isHomePageTitle, true);
		test.log(LogStatus.PASS, "Logged-in successful");
	}

	@AfterClass
	public void endTest() {
		report.endTest(test);
		report.flush();
	}
}
