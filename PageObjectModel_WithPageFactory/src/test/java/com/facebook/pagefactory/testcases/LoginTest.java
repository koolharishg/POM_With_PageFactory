package com.facebook.pagefactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.pagefactory.pages.LaunchPage;
import com.facebook.pagefactory.pages.LoginPage;
import com.facebook.pagefactory.session.LandingPage;
import com.facebook.pagefactory.testcases.base.BaseTest;
import com.facebook.pagefactory.util.DataUtil;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {
	String testcasename = "LoginTest";

	@Test(dataProvider = "testdata")
	public void doLogin(Hashtable<String, String> mydata) {

		if (!DataUtil.isTestExecutable(xls, testcasename) || mydata.get(FBConstants.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.INFO, "skipping the test because runmode is N");
			throw new SkipException("skipping the test");
		}

		test = extent.startTest("Starting Login Test");
		test.log(LogStatus.INFO, "initializing browser");
		init(mydata.get("Browser"));

		LaunchPage lp = new LaunchPage(driver, test);
		PageFactory.initElements(driver, lp);
		LoginPage loginpage = lp.gotoLoginPage();

		test.log(LogStatus.INFO, "logging in");
		Object page = loginpage.doLogin(mydata.get("Username"), mydata.get("Password"));
		String actualresult = "";
		if (page instanceof LandingPage) {
			test.log(LogStatus.PASS, "Login Test Passed");
			actualresult = "success";
		} else {

			actualresult = "unsuccessful";
		}

		if (!actualresult.equals(mydata.get("ExpectedResult"))) {

			report_failure("Test Failed");
		}

		test.log(LogStatus.PASS, "Login Test Passes");
	}

	@DataProvider
	public Object[][] testdata() {
		return DataUtil.testdata(xls, testcasename);
	}

	@AfterMethod
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		if (driver != null)
			driver.quit();
	}
}
