package com.orangehrm.listener_utilites;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.basic_utilites.BaseClass;

public class MyListner implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public ExtentReports reports;

	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReports/reports" + time + ".html");
		spark.config().setDocumentTitle("OrangeHrm Test Suite");
		spark.config().setReportName("OrangeHrm");
		spark.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows11");
		reports.setSystemInfo("BROWSER", "chrome");

	}

	// It Will Get Executed Multiple Times When TestCase Executed
	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "-->Started");

	}

	// It Will Get Executed When Test Case Executed Successfully
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "-->Passed And Completed");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, result.getMethod().getMethodName());

	}

	// It Will Get Executed When TeseCase Fail'd
	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getMethod().getMethodName();
		// Take ScreenShot
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, TestName + " " + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + " --> Faild");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println();
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
	}

}
