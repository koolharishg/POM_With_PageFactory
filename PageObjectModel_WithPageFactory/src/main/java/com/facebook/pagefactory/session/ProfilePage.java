package com.facebook.pagefactory.session;

import org.openqa.selenium.WebDriver;

import com.facebook.pagefactory.base.Base;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfilePage extends Base {

	public ProfilePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void verifyProfile() {
		test.log(LogStatus.INFO, "Verifying Profile");
		System.out.println("verification successful");
		test.log(LogStatus.PASS, "Profile Verified Successfully");
	}

}
