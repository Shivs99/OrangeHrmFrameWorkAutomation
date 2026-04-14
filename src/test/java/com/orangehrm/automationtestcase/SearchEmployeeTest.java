package com.orangehrm.automationtestcase;

import org.testng.annotations.Test;

import com.orangehrm.basic_utilites.BaseClass;

public class SearchEmployeeTest extends BaseClass {

	@Test
	public void SearchIngEmployee(String name)
	{
		System.out.println(name+" Employee Found");
	}
	
	@Test
	public void searchIngEmployee(int id)
	{
		System.out.println("Employee Name :Shivu and Id:"+id);
	}
	
	
}
