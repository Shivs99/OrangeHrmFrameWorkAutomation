package com.orangehrm.basic_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.file_utilities.ExcelUtility;
import com.orangehrm.file_utilities.FileUtility;
import com.orangehrm.objectrepositry_utilites.HomePage;
import com.orangehrm.objectrepositry_utilites.LoginPage;
import com.orangehrm.webdriver_utilites.WebDriverUtility;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	FileUtility fUtil = new FileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	ExcelUtility exUtil = new ExcelUtility();

	String URL;
	String USERNAME;
	String PASSWORD;
	String BROWSER;

	@BeforeClass
	public void launchBrowser() throws Exception {

		BROWSER = fUtil.getDataFromPropertyFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
	}

	@BeforeMethod
	public void loginToApplication() throws Exception {

		URL = fUtil.getDataFromPropertyFile("url");
		USERNAME = fUtil.getDataFromPropertyFile("username");
		PASSWORD = fUtil.getDataFromPropertyFile("password");

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logoutFromApplication() {

		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
