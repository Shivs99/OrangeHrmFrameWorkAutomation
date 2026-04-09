package com.orangehrm.automationtestcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	@Test
	public void addEmpTest()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		spark .config().setDocumentTitle("OrangeHrm Test Suite");
		spark.config().setReportName("OrangeHrm");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Window11");
		report.setSystemInfo("BROWSER", "Chrome");
		ExtentTest test=report.createTest("addEmpTest");
		
		test.log(Status.INFO, "Login To Hrm");
		test.log(Status.INFO, "Click On PIM");
		test.log(Status.INFO, "Add Emp");
		if("Shiv".equals("Shiv"))
			test.log(Status.PASS, "EmpAddedd");
		else
			test.log(Status.FAIL, "TestIs Faild");
		
		report.flush();
	}
}
