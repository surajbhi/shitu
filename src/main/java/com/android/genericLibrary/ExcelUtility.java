package com.android.genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	/**
	 * It is developed using Apache POI libraries, Which is used to handle Microsoft Excel sheet 
	 * @author A1Q5SAYJ(PRAKASH)
	 */

	/**
	 * It is used to read the data from Excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;		
	}
	/**
	 * It is used to get the latest used row number on specified Sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */

	public int getDataFromExcelNum(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int data = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getNumericCellValue();
		wb.close();
		return data;		
	}
	/**
	 * It is used to get the latest used row number on specified Sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	public boolean getDataFromExcelBoolean(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		boolean data = (boolean) wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getBooleanCellValue();
		wb.close();
		return data;		
	}

	/**
	 * It is used to get the latest used row number on specified Sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * It is used to get the latest used row number on specified Sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */

	public void setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {	
		FileInputStream fis= new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos= new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();		
	}

}
