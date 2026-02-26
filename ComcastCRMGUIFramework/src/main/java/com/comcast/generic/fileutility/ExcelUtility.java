package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheet,int row,int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Testdata/ReaddataWithCondition.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		Cell c=r.getCell(col);
	    String data=c.getStringCellValue();
	    wb.close();
		return data;
	}
   
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Testdata/ReaddataWithCondition.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    int rowNum=	wb.getSheet(sheetName).getLastRowNum();
	    wb.close();
	    return rowNum;
	}
	
	public void setDataIntoExcel(String sheet,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Testdata/ReaddataWithCondition.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		Cell c=r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./Testdata/ReaddataWithCondition.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
