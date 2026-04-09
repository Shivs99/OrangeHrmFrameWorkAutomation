package com.orangehrm.webdriver_utilites;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void goToUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizePage(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void pageRefresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void moveForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void moveBackWard(WebDriver driver) {
		driver.navigate().back();
	}

	public void switchTOWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
		}
	}

	public void selectDropDown(WebDriver driver, WebElement element, String visibileText) {
		Select select = new Select(element);
		select.selectByContainsVisibleText(visibileText);
	}

	public void selectDropDown(WebDriver driver, WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).click().build().perform();
	}

	public void scrollByElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).build().perform();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void disableNotification(WebDriver driver) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}

	public void closePage(WebDriver driver) {
		driver.close();
	}

	public void quitPage(WebDriver driver) {
		driver.quit();
	}

}
