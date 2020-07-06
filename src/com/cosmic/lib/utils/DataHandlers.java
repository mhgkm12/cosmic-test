package com.cosmic.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers
{

public static String getDataFromExcel(String fileName, String sheetName, int rowIndex,
			int cellIndex)
	{
		String data = null; 
		try 
		{
			File f = new File("./test-data/" + fileName + ".xls");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
public static String getDataFromProperties(String fileName, String key)
	{
		String data = null;
		try
		{
			File f = new File("./config-data/" + fileName + ".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = prop.get(key).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
public static void setDataToExcel (String fileName, String sheetName, 
		int rowIndex, int cellIndex, String data)
{
	try
	{
		File f = new File("./test-data/" + fileName + ".xls");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheetName);
		Row r = st.createRow(rowIndex);
		Cell c = r.createCell(cellIndex);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
		
public static void SetDataToProperties (String fileName, String key, String value, 
				String commitMsg)
		{
			try 
			{
				File f = new File("./config-data/" + fileName + ".properties");
				FileInputStream fis = new FileInputStream(f);
				Properties prop = new Properties(); 
				prop.load(fis);
				prop.put(key, value);
				FileOutputStream fos = new FileOutputStream(f);
				prop.store(fos, commitMsg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
