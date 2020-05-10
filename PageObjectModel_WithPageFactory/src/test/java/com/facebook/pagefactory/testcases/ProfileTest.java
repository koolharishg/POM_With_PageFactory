package com.facebook.pagefactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.pagefactory.pages.LaunchPage;
import com.facebook.pagefactory.pages.LoginPage;
import com.facebook.pagefactory.session.LandingPage;
import com.facebook.pagefactory.session.ProfilePage;
import com.facebook.pagefactory.testcases.base.BaseTest;
import com.facebook.pagefactory.util.DataUtil;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.LogStatus;

public class ProfileTest extends BaseTest {

	String testcasename = "ProfileTest";

	@Test
	public void testProfile(Hashtable<String, String> mydata) {

		if (!DataUtil.isTestExecutable(xls, testcasename) || mydata.get(FBConstants.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.INFO, "skipping the test because runmode is N");
			throw new SkipException("skipping the test");
		}

		test = extent.startTest("Profile Test");
		test.log(LogStatus.INFO, "Starting Profie Test");
		init("Chrome");
		LaunchPage lp = new LaunchPage(driver, test);
		PageFactory.initElements(driver, lp);
		LoginPage loginpage = lp.gotoLoginPage();

		// loginpage.verifyTitle("Facebook login");

		Object page = loginpage.doLogin("koolharishg@gmail.com", "donnoone");

		if (page instanceof LoginPage)
			Assert.fail("login failed");
		else if (page instanceof LandingPage)
			System.out.println("login successful");

		LandingPage landingpage = (LandingPage) page;

		ProfilePage profilepage = landingpage.gotoProfilePage();
		profilepage.verifyProfile();
		// profilepage.getMenu().logout();

	}

	@AfterMethod
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}

	}

	@DataProvider
	public Object[][] testdata() {
		return DataUtil.testdata(xls, testcasename);
	}
}
