package com.facebook.pagefactory.session.GeneralSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.pagefactory.base.Base;
import com.relevantcodes.extentreports.ExtentTest;

public class GeneralSettingsPage extends Base {

	@FindBy(xpath = "//div[contains(text(), 'Security and login')]")
	public WebElement security;

	public GeneralSettingsPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public SecurityLoginPage gotoSecurity() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(security));
		security.click();
		SecurityLoginPage securitylogin = new SecurityLoginPage(driver, test);
		PageFactory.initElements(driver, securitylogin);
		return securitylogin;
	}

}
