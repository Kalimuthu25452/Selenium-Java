package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonActions {

	private WebDriver driver = null;

	// Constructor
	public CommonActions(WebDriver driver) {
		this.driver = driver;
	}

	public boolean click(By locator) {
		driver.findElement(locator).click();

		return true;
	}

	public void takeSnapShot(String fileWithPath) throws IOException {

		// Convert web driver object to TakeScreenshot and Call getScreenshotAs method to create image file
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
