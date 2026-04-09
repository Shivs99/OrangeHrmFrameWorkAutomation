package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement SearchEmployeeName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']//child::button[@type='button']")
    private WebElement resetButton;

    public WebElement getSearchEmployeeName() {
        return SearchEmployeeName;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public void scrollUpPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollup(0,-500)");
    }

    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

}
