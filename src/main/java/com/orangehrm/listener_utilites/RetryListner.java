package com.orangehrm.listener_utilites;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count = 0;
		int limit = 5;
		if (count < limit) {
			count++;
			return true;
		}
		return false;
	}

}
