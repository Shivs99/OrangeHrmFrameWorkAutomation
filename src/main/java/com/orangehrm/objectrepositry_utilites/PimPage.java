package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

    WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Add Employee")
    private WebElement ClickaddEmployee;

    @FindBy(xpath = "//div[@class='']//input[@class='oxd-input oxd-input--active']")
    private WebElement searchEmpById;


    public WebElement getClickaddEmployee() {
        return ClickaddEmployee;
    }


    public void ClickOnEmployee() {
        getClickaddEmployee().click();
    }

    public WebElement getSearchEmpById() {
        return searchEmpById;
    }

    public String searchEmpById() {
        return getSearchEmpById().getAttribute("value");
    }

}



