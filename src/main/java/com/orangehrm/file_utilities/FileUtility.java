package com.orangehrm.file_utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

	// Read Data From Properties File
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./ConfigurationData/CommonData.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	// Read Data From JSON File
	public String getDateFromJsonFile(String key) throws Throwable, Exception {
		FileReader fr = new FileReader("./ConfiguarationData/AppCommonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject json = (JSONObject) obj;
		return json.get(key).toString();
	}
}
