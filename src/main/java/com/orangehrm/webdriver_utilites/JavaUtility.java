package com.orangehrm.webdriver_utilites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}

	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
		String formateDate = sim.format(date);
		return formateDate;
	}
}
