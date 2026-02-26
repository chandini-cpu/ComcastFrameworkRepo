package com.comcast.crm.contacttest;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class CreateContactWithSupportDateTest extends BaseClass{
	
	public static void main(String[] args) throws IOException {
		
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
			
			driver.findElement(By.linkText("Contacts")).click();
			
			 //read testscript data from excel file
			 String lastname=elib.getDataFromExcel("con", 1, 2)+jlib.getRandomNumber();
			// String sadd=row.getCell(3).toString();
				
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();	
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				
				String actualdate=jlib.getSystemDateYYYYDDMM();
				String enddateRequires=jlib.getRequiredDateYYYYDDMM(30);  //if we give negative number previous days will get
				
				//System.out.println(dateRequires);
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(actualdate);
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(enddateRequires);
			
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify header orgname information expected result
				
				String actualstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actualdate.equals(actualstartdate))
				{
					System.out.println(actualdate +"is correct");
				}
				else
				{
					System.out.println(actualdate +"is not correct");
				}
				
				
				String actualenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(enddateRequires.equals(actualenddate))
				{
					System.out.println(enddateRequires +"is correct");
				}
				else
				{
					System.out.println(enddateRequires +"is not correct");
				}
				
		}


	}
	




