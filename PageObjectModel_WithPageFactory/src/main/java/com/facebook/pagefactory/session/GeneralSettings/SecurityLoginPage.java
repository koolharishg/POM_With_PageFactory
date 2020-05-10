package com.facebook.pagefactory.session.GeneralSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.facebook.pagefactory.base.Base;
import com.facebook.pagefactory.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;

public class SecurityLoginPage extends Base {

	@FindBy(xpath = FBConstants.CHANGE_PASSWORD)
	public WebElement clickchangepwd;

	@FindBy(xpath = FBConstants.PASSWORD_OLD)
	public WebElement pwd_old;

	@FindBy(xpath = FBConstants.PASSWORD_NEW)
	public WebElement pwd_new;

	@FindBy(xpath = FBConstants.PASSWORD_CONFIRM)
	public WebElement pwd_confirm;

	@FindBy(xpath = FBConstants.REVIEW_DEVICES)
	public WebElement review_devices;

	@FindBy(xpath = FBConstants.SAVE_CHANGES)
	public WebElement save_changes;

	@FindBy(xpath = FBConstants.CONTINUE_BUTTON)
	public WebElement continue_button;

	public SecurityLoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void gotoPasswordChange() {
		clickchangepwd.click();

	}

	public void doPasswordChange(String oldpwd, String newpwd) {
		pwd_old.sendKeys(oldpwd);
		pwd_new.sendKeys(newpwd);
		pwd_confirm.sendKeys(newpwd);
		save_changes.click();

	}

}
