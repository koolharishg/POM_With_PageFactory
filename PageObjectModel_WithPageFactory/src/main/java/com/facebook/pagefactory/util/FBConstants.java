package com.facebook.pagefactory.util;

public class FBConstants {

	// paths
	public static final String CHROME_DRIVER_EXE = "C:\\Users\\ghorh\\Documents\\selenium-bazinga\\Drivers\\chromedriver.exe";
	public static final String REPORTS_PATH = "C:\\Users\\ghorh\\eclipse-workspace\\PageObjectModel_WithPageFactory\\";

	// locators
	public static final String LOGIN_EMAIL = "//input[@id='email']";
	public static final String LOGIN_PASSWORD = "//input[@id='pass']";
	public static final String LOGIN_BUTTON = "//input[@type='submit']";
	public static final String PROFILEPAGE_LINK = "//div[@class='linkWrap noCount']";
	public static final String FB_URL = "http://facebook.com";
	public static final String FBURL = "http://facebook.com";
	public static final String TEST_DATA_PATH = "C:\\Users\\ghorh\\eclipse-workspace\\PageObjectModel_WithPageFactory\\Data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String CHANGE_PASSWORD = "//span[contains(text(), 'Change password')]";
	public static final String PASSWORD_OLD = "//input[@id='password_old']";
	public static final String PASSWORD_NEW = "//input[@id='password_new']";
	public static final String PASSWORD_CONFIRM = "//input[@id='password_confirm']";
	public static final String REVIEW_DEVICES = "//div[text()='Review other devices']";
	public static final String SAVE_CHANGES = "//input[@value='Save Changes']";
	public static final String CONTINUE_BUTTON = "//button[text()='Continue']";
	public static final String TESTCASES_SHEET = "TestCases";

}
