package com.facebook.pagefactory.testcases.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.facebook.pagefactory.util.ExtentManager;
import com.facebook.pagefactory.util.FBConstants;
import com.facebook.pagefactory.util.XlsReaderBazinga;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public XlsReaderBazinga xls = new XlsReaderBazinga(FBConstants.TEST_DATA_PATH);

	public void init(String bType) {
		test.log(LogStatus.INFO, "Opening Browser");
		if (bType.equals("Mozilla")) {
			driver = new FirefoxDriver();
		} else if (bType.equals("Chrome")) {
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--disable-notifications");
			driver = new ChromeDriver(cr);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Browser opened successfully");
	}

	public void report_failure(String failuremessage) {
		test.log(LogStatus.FAIL, failuremessage);
		takeScreenShot();
		Assert.fail(failuremessage);
	}

	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = FBConstants.REPORTS_PATH + "\\ExtentReportsscreenshots//" + screenshotFile;
		System.out.println(filePath);
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
}
