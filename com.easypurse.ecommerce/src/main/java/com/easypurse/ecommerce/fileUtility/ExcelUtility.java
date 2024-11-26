package com.easypurse.ecommerce.fileUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	public int getLastRowNum(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}

	public int getLastCellNum(String sheetName, int rowNum) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetName).getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	public void setDataBackToExcel(String sheetName, int rowNum, int cellNum,String data) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Cell cel = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	    cel.setCellType(CellType.STRING);
	    cel.setCellValue(data);
	    
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
	    wb.write(fos);
	    wb.close();

	}

}
