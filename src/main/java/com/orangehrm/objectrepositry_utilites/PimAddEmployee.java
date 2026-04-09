package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimAddEmployee {

	WebDriver driver;

	public PimAddEmployee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "middleName")
	private WebElement middleName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//div[@class='orangehrm-employee-container']//input[@class='oxd-input oxd-input--active']")
	private WebElement empid;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmpid() {
		return empid;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public void addEmployee(String fname, String midname, String lasname, String empId) {
		getFirstName().sendKeys(fname);
		getMiddleName().sendKeys(midname);
		getLastName().sendKeys(lasname);
		getEmpid().sendKeys(empId);
		getSavebutton().click();
	}

}
