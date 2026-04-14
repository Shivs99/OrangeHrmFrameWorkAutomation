package com.orangehrm.automationtestcase;

import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;

public class DeleteEmployeeTest extends BaseClass {

	@Test
	public void deleteEmployee(String name)
	{
		System.out.println(name+" Employee Deleted");
	}
}
