package com.facebook.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.pagefactory.base.Base;
import com.facebook.pagefactory.session.LandingPage;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends Base {

	@FindBy(xpath = FBConstants.LOGIN_EMAIL)
	public WebElement email;

	@FindBy(xpath = FBConstants.LOGIN_PASSWORD)
	public WebElement pass;

	@FindBy(xpath = FBConstants.LOGIN_BUTTON)
	public WebElement login;

	public LoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public Object doLogin(String username, String password) {
		email.sendKeys(username);
		pass.sendKeys(password);
		login.click();

		// logic to verify successful login
		boolean loginsuccess = isElementPresent(FBConstants.PROFILEPAGE_LINK);

		if (loginsuccess) {
			LandingPage landingpage = new LandingPage(driver, test);
			PageFactory.initElements(driver, landingpage);
			return landingpage;
		} else {
			LoginPage loginpage = new LoginPage(driver, test);
			PageFactory.initElements(driver, loginpage);
			return loginpage;
		}
	}

}
