package com.facebook.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebook.pagefactory.base.Base;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends Base {

	public LaunchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public LoginPage gotoLoginPage() {
		test.log(LogStatus.INFO, "opening url--" + FBConstants.FBURL);
		driver.get(FBConstants.FBURL);
		LoginPage loginpage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
	}
}
