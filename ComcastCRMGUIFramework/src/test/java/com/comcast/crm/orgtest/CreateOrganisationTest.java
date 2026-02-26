package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class CreateOrganisationTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
			 String orgname= elib.getDataFromExcel("Sheet1", 1, 2)+jlib.getRandomNumber();		 
			 String sadd=elib.getDataFromExcel("Sheet1", 1, 2)+jlib.getRandomNumber();
			 
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				driver.findElement(By.name("ship_street")).sendKeys(sadd);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify header msg expected result
				//WebElement header=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dvHeaderText']")));
				String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(orgname))
				{
					System.out.println(orgname +"is created");
				}
				else
				{
					System.out.println(orgname +"is not created");
				}
				//verify header orgname information expected result
				
				String actualOrgname=driver.findElement(By.id("dtlview_Organization Name")).getText();
				if(headerInfo.equals(actualOrgname))
				{
					System.out.println(orgname +"is created");
				}
				else
				{
					System.out.println(orgname +"is not created");
				}
		}
			
			
	

}
