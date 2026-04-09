package com.orangehrm.automationtestcase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;
import com.orangehrm.file_utilities.ExcelUtility;
import com.orangehrm.listener_utilites.MyListner;
import com.orangehrm.objectrepositry_utilites.DashBoardPage;
import com.orangehrm.objectrepositry_utilites.HomePage;
import com.orangehrm.objectrepositry_utilites.PimAddEmployee;
import com.orangehrm.objectrepositry_utilites.PimPage;

@Listeners(MyListner.class)
public class AddEmployeeTest extends BaseClass {

    ExcelUtility excel = new ExcelUtility();

    @Test
    public void addEmployeeTest() throws Throwable {

        // Navigate to PIM
        HomePage homePage = new HomePage(driver);
        homePage.ClickOnPimElement();

        // Click Employee List
        PimPage pimPage = new PimPage(driver);
        pimPage.ClickOnEmployee();

        // Read data from Excel
        String firstName = excel.getDataFromExcel("Employees", 1, 0);
        String middleName = excel.getDataFromExcel("Employees", 1, 1);
        String lastName = excel.getDataFromExcel("Employees", 1, 2);
        String empId = excel.getDataFromExcel("Employees", 1, 3);

        // Add Employee
        PimAddEmployee addEmployeePage = new PimAddEmployee(driver);
        addEmployeePage.addEmployee(firstName, middleName, lastName, empId);

        //Verify
        DashBoardPage dp = new DashBoardPage(driver);
        String actualText = dp.getDashboardElement().getText();
        String expectedText = "Shiv";

        Assert.assertEquals(actualText, expectedText);
        System.out.println("Employee added and verified successfully ");
    }
}