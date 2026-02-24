package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class CreateOrgWithPhoneno {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
         Fileutility flib=new Fileutility();
         ExcelUtility elib=new ExcelUtility();
         JavaUtility jlib=new JavaUtility();
         
         String browser=flib.getDataFromPropertiesFile("browser");
		 String url=flib.getDataFromPropertiesFile("url");
		 String username=flib.getDataFromPropertiesFile("username");
		 String password=flib.getDataFromPropertiesFile("password");
		
		 
		   WebDriver driver=null;
		   if(browser.equals("chrome"))
		   {
			   driver=new ChromeDriver();
		   }
		   else
		   {
			   driver=new FirefoxDriver();
		   }
		   driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			
			
			//read testscript data from excel file
			 
			 String orgname=elib.getDataFromExcel("Sheet1", 7, 2)+jlib.getRandomNumber();
			 String sadd=elib.getDataFromExcel("Sheet1", 7, 3);
			 String industry=elib.getDataFromExcel("Sheet1", 7, 4);
			 String type=elib.getDataFromExcel("Sheet1", 7, 5);
//			 String ph=row.getCell(6).getNumericCellValue().toString();
			 String pj=elib.getDataFromExcel("Sheet1", 7, 6);
			 
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				driver.findElement(By.name("ship_street")).sendKeys(sadd);
				driver.findElement(By.id("phone")).sendKeys(pj);
//				WebElement dd1=driver.findElement(By.name("industry"));
//				Select s=new Select(dd1);
//				WebElement dd2=driver.findElement(By.name("accounttype"));
//				Select s1=new Select(dd2);
//				s.selectByVisibleText(industry);
//				s1.selectByVisibleText(type);
//				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				//validation
				System.out.println(pj);
				String fg =driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
				if(fg.equals(pj))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}


	}

}
