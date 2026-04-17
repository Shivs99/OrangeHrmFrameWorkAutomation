package com.orangehrm.automationtestcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;
import com.orangehrm.objectrepositry_utilites.HomePage;
import com.orangehrm.objectrepositry_utilites.PimPage;

public class SearchEmployeeTest extends BaseClass {

	@Test(dataProvider = "getData")
	public void searchEmployee(String name, int id) {
		HomePage hm = new HomePage(driver);
		hm.ClickOnPimElement();
		PimPage pim = new PimPage(driver);
		pim.searchEmpById();
		System.out.println(name + " Found With Id :" + id);
	}

	@Test
	@DataProvider
	public Object[][] getData() {
		Object obj[][] = new Object[3][2];
		obj[0][0] = "Shiv";
		obj[0][1] = 999;

		obj[1][0] = "Raghu";
		obj[1][1] = 88;

		obj[2][0] = "Harsha";
		obj[2][1] = 55;

		return obj;
	}

}
