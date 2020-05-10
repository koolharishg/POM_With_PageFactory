package com.facebook.pagefactory.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.pagefactory.common.TopMenu;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public TopMenu menu;
	public WebDriver driver;
	public ExtentTest test;
	public WebDriverWait wait;

	public Base() {
	}

	public Base(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		menu = new TopMenu(driver, test);
		PageFactory.initElements(driver, menu);

	}

	public String verifyTitle(String expTitle) {
		return "";
	}

	public TopMenu getMenu() {
		return menu;
	}

	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = FBConstants.REPORTS_PATH + "\\ExtentReportsscreenshots" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}

	public boolean isElementPresent(String locator) {
		int s = driver.findElements(By.xpath(locator)).size();

		if (s == 0) {
			test.log(LogStatus.INFO, "Element found");
			return false;
		} else {
			test.log(LogStatus.INFO, "Element not found");
			return true;
		}
	}
}
