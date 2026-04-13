package com.orangehrm.objectrepositry_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class EmployeeSearchPage {

    WebDriver driver;

    public EmployeeSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Search Form Elements
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/following-sibling::div//input")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//label[text()='Employment Status']/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement employmentStatusSelect;

    @FindBy(xpath = "//label[text()='Include']/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement includeSelect;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    private WebElement supervisorNameInput;

    @FindBy(xpath = "//label[text()='Job Title']/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement jobTitleSelect;

    @FindBy(xpath = "//label[text()='Sub Unit']/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement subUnitSelect;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    // Table Result Elements
    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']//div[@role='cell']")
    private List<WebElement> tableCells;

    // Getters for Search Form Elements
    public WebElement getEmployeeNameInput() {
        return employeeNameInput;
    }

    public WebElement getEmployeeIdInput() {
        return employeeIdInput;
    }

    public WebElement getEmploymentStatusSelect() {
        return employmentStatusSelect;
    }

    public WebElement getIncludeSelect() {
        return includeSelect;
    }

    public WebElement getSupervisorNameInput() {
        return supervisorNameInput;
    }

    public WebElement getJobTitleSelect() {
        return jobTitleSelect;
    }

    public WebElement getSubUnitSelect() {
        return subUnitSelect;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    // Getters for Table Elements
    public List<WebElement> getTableRows() {
        return tableRows;
    }

    public int getTableRowCount() {
        return getTableRows().size();
    }

    // Methods to extract employee data from table results
    public String getEmployeeIdFromTable(int rowIndex) {
        // ID is the 2nd cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 1) {
            return cells.get(1).getText();
        }
        return "";
    }

    public String getEmployeeFirstNameFromTable(int rowIndex) {
        // First (& Middle) Name is the 3rd cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 2) {
            return cells.get(2).getText();
        }
        return "";
    }

    public String getEmployeeLastNameFromTable(int rowIndex) {
        // Last Name is the 4th cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 3) {
            return cells.get(3).getText();
        }
        return "";
    }

    public String getEmployeeJobTitleFromTable(int rowIndex) {
        // Job Title is the 5th cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 4) {
            return cells.get(4).getText();
        }
        return "";
    }

    public String getEmployeeEmploymentStatusFromTable(int rowIndex) {
        // Employment Status is the 6th cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 5) {
            return cells.get(5).getText();
        }
        return "";
    }

    public String getEmployeeSubUnitFromTable(int rowIndex) {
        // Sub Unit is the 7th cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 6) {
            return cells.get(6).getText();
        }
        return "";
    }

    public String getEmployeeSupervisorFromTable(int rowIndex) {
        // Supervisor is the 8th cell in each row
        String xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'][" + (rowIndex + 1) + "]//div[@role='cell']//div";
        List<WebElement> cells = driver.findElements(org.openqa.selenium.By.xpath(xpath));
        if (cells.size() > 7) {
            return cells.get(7).getText();
        }
        return "";
    }

    // Get all employee details as a map from specific row
    public String[] getEmployeeDetailsFromTable(int rowIndex) {
        String[] employeeDetails = new String[7];
        employeeDetails[0] = getEmployeeIdFromTable(rowIndex);
        employeeDetails[1] = getEmployeeFirstNameFromTable(rowIndex);
        employeeDetails[2] = getEmployeeLastNameFromTable(rowIndex);
        employeeDetails[3] = getEmployeeJobTitleFromTable(rowIndex);
        employeeDetails[4] = getEmployeeEmploymentStatusFromTable(rowIndex);
        employeeDetails[5] = getEmployeeSubUnitFromTable(rowIndex);
        employeeDetails[6] = getEmployeeSupervisorFromTable(rowIndex);
        return employeeDetails;
    }

    // Methods for Search Form Actions
    public void enterEmployeeName(String name) {
        getEmployeeNameInput().sendKeys(name);
    }

    public void enterEmployeeId(String id) {
        getEmployeeIdInput().sendKeys(id);
    }

    public void clickSearch() {
        getSearchButton().click();
    }

    public void clickReset() {
        getResetButton().click();
    }

}
