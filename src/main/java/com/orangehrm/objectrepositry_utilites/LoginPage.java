package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement userName_edit;

	@FindBy(name = "password")
	private WebElement password_edit;

	@FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']//child::button[@type='submit']")
	private WebElement loginButton;

	public WebElement getUserName_edit() {
		return userName_edit;
	}

	public WebElement getPassword_edit() {
		return password_edit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public void login(String userName,String password)
	{
		userName_edit.sendKeys(userName);
		password_edit.sendKeys(password);
		loginButton.click();

	}

}
