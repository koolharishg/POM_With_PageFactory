package com.facebook.pagefactory.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.pagefactory.base.Base;
import com.facebook.pagefactory.session.GeneralSettings.GeneralSettingsPage;
import com.relevantcodes.extentreports.ExtentTest;

public class TopMenu {
	public Base base;

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//div[@id='userNavigationLabel']")
	public WebElement settingsdropdown;

	@FindBy(xpath = "//span[text()='Settings']")
	public WebElement settings;

	public TopMenu(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void logout() {

	}

	public GeneralSettingsPage gotoSettings() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(settingsdropdown));
		settingsdropdown.click();
		wait.until(ExpectedConditions.visibilityOf(settings));
		settings.click();
		GeneralSettingsPage settings = new GeneralSettingsPage(driver, test);
		PageFactory.initElements(driver, settings);
		return settings;
	}

	public void Search() {

	}

}
