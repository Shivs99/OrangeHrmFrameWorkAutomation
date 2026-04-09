package com.orangehrm.file_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
public class ExcelUtility {

	public int getNoRowsCount(String sheetname) throws Exception, IOException {
		FileInputStream fis = new FileInputStream("./TestScriptData/EmployeeData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.close();
		return book.getSheet(sheetname).getLastRowNum();

	}

	public String getDataFromExcel(String sheetname, int row, int cell) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./TestScriptData/EmployeeData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row rows = sheet.getRow(row);
		Cell cells = rows.getCell(cell);
		DataFormatter format = new DataFormatter();
		book.close();
		return format.formatCellValue(cells);
	}

	public void writeDataToExcel(String sheetname, int row, int cell, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./TestScriptData/EmployeeData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(data);

		FileOutputStream fos = new FileOutputStream("./TestScriptData/EmployeeData.xlsx");
		book.write(fos);
		book.close();
		fos.close();
	}

}
