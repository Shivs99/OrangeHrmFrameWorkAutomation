package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='oxd-topbar-header-userarea']//child::i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement dropdown;

	public WebElement getDropdown() {
		return dropdown;
	}

	@FindBy(linkText =  "Logout")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).click().build().perform();
        action.moveToElement(logout).click().build().perform();
	}
}
