package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement admin;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement clickOnPim;

	@FindBy(xpath = "//div[@class='oxd-topbar-header-userarea']//child::i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement dropdown;

	@FindBy(linkText = "Logout")
	private WebElement logout;

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getClickOnPim() {
		return clickOnPim;
	}

	public void ClickOnPimElement() {
		clickOnPim.click();
	}

	public boolean adminElementVisible() {
		return admin.isDisplayed();
	}

	public void clickOnAdminElement() {
		if (adminElementVisible()) {
			getAdmin().click();
		}
	}

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).click().build().perform();
		action.moveToElement(logout).click().build().perform();
	}

}
