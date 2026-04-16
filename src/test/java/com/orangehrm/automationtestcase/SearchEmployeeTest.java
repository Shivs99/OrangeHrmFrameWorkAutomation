package com.orangehrm.automationtestcase;

import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;
import com.orangehrm.objectrepositry_utilites.HomePage;
import com.orangehrm.objectrepositry_utilites.PimPage;

public class SearchEmployeeTest extends BaseClass {

	@Test
	public void SearchIngEmployee()
	{
		HomePage hm=new HomePage(driver);
		hm.ClickOnPimElement();
		PimPage pm=new PimPage(driver);
		pm.searchEmpById();
		System.out.println("Shivu "+" Employee Found");
	}
	
	@Test
	public void searchIngEmployee()
	{
		HomePage hm=new HomePage(driver);
		hm.ClickOnPimElement();
		PimPage pm=new PimPage(driver);
		pm.searchEmpById();
		System.out.println("Employee Name :Shivu and Id is 9999:");
	}
	
	
}
