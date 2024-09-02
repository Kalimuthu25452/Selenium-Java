package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

// Created Utilities folder and Classes
import utilities.CommonActions;
import utilities.ReadPropertyFile;

@Listeners()
public class BaseListerner {

	public static WebDriver driver;

	// 'Property Files declarations'
	public static Properties prop_inputs;
	public static Properties prop_locators;
	
	// "Get User Directory"
	String userDir = System.getProperty("user.dir");

	@BeforeSuite
	public void setup() throws IOException {
		// 'Load File Property values on initiation'
		if (driver == null) {

			prop_inputs = ReadPropertyFile.read(userDir + "\\src\\test\\resources\\testData\\config.properties");

			prop_locators = ReadPropertyFile.read(userDir + prop_inputs.getProperty("locatorsPropertyFilePath"));

			//report = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\");
			
		}

		// 'Initiate Driver'
		if (prop_inputs.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop_inputs.getProperty("browser").equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// 'Maximize window size'
		driver.manage().window().maximize();

		// 'Navigate to Base URL'
		driver.get(prop_inputs.getProperty("baseURL"));
		// log.info("Success: Navigate to Login page");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String folderPath = userDir + "\\test-output\\Screenshots(Failed cases)\\";
			String filePath = result.getMethod().getMethodName();
			String fileFormat = ".png";
			
			System.out.println("***** Failed: " + result.getName() + " test has failed *****");

			CommonActions screensnapMethod = new CommonActions(driver);
			screensnapMethod.takeSnapShot(folderPath + filePath + fileFormat);
			
			//System.out.println("Screenshot stored in: " + folderPath + filePath + fileFormat);
		}
	}

	@AfterSuite
	public void tear() {
		if (driver != null) {
			driver.close();
			// log.info("Success: Close Browser");
		}
	}
}
