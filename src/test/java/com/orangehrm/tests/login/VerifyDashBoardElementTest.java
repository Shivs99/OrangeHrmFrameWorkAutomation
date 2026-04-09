package com.orangehrm.tests.login;

import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;
import com.orangehrm.objectrepositry_utilites.HomePage;

public class VerifyDashBoardElementTest extends BaseClass {

	@Test
	public void verifyAdminElementVisibleTest() {
		HomePage hm = new HomePage(driver);
		hm.clickOnAdminElement();
	}
}
