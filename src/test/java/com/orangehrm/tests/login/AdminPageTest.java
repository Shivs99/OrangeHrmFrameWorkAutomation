package com.orangehrm.tests.login;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;
import com.orangehrm.listener_utilites.MyListner;
import com.orangehrm.objectrepositry_utilites.AdminPage;
import com.orangehrm.objectrepositry_utilites.HomePage;

@Listeners(MyListner.class)
public class AdminPageTest extends BaseClass {

	@Test
	public void adminPageTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hm=new HomePage(driver);
		if(hm.adminElementVisible())
			hm.clickOnAdminElement();
		AdminPage adminpage = new AdminPage(driver);
		String expectedName = "Shiva";
		 String actual=adminpage.getSearchEmployeeName().getAttribute("value");
		if (adminpage.getSearchButton().isEnabled())
			adminpage.getSearchButton().click();
		Assert.assertEquals(expectedName, actual);
		
	}
}
