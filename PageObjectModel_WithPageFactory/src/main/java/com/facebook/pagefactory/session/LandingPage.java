package com.facebook.pagefactory.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.pagefactory.base.Base;
import com.relevantcodes.extentreports.ExtentTest;

public class LandingPage extends Base {

	@FindBy(xpath = "//div[@class='linkWrap noCount']")
	public WebElement profilelink;

	public LandingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public ProfilePage gotoProfilePage() {

		profilelink.click();
		ProfilePage profilepage = new ProfilePage(driver, test);
		profilepage = PageFactory.initElements(driver, ProfilePage.class);
		return profilepage;
	}

}
