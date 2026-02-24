package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
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
		    wlib.waitForPageToLoad(driver);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			
			 
			 //read testscript data from excel file
			 String orgname=elib.getDataFromExcel("con", 7, 2)+jlib.getRandomNumber();
			 String sadd=elib.getDataFromExcel("con", 7, 5);
			 String contactln=elib.getDataFromExcel("con", 7, 3);
				
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
				if(orgname.equals(actualOrgname))
				{
					System.out.println(orgname +"is created");
				}
				else
				{
					System.out.println(orgname +"is not created");
				}
				
				//create contact 

				    driver.findElement(By.linkText("Contacts")).click();
					
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();	
					driver.findElement(By.name("lastname")).sendKeys(contactln);
					String parent=driver.getWindowHandle();
				    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
				    Thread.sleep(1000); 
				    wlib.switchToTabOnurl(driver, "module=Accounts");
				   /* Set<String> child=driver.getWindowHandles();
					
					 * Iterator<String> it=child.iterator(); while(it.hasNext()) { String
					 * winid=it.next(); driver.switchTo().window(winid); String
					 * acturl=driver.getCurrentUrl(); if(acturl.contains("module=Accounts")) {
					 * break; } }
					 */
				    
					/*
					 * for(String n:child) { driver.switchTo().window(n);
					 * if(driver.getCurrentUrl().contains(
					 * "http://49.249.28.218:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="
					 * )) {
					 */
				       driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(orgname);
					  //Thread.sleep(1000);
					  driver.findElement(By.xpath("//input[@type='button']")).click();
					  //Thread.sleep(1000);
					  WebElement link=  driver.findElement(By.xpath("//a[text()='"+orgname+"']"));//dynamic xpath
					  WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(15));
					  wait1.until(ExpectedConditions.elementToBeClickable(link));
					  driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
					  driver.switchTo().window(parent); 
					 
				    
				    
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
					//verify header orgname information expected result
					
					String actuallastname=driver.findElement(By.id("dtlview_Last Name")).getText();
					if(contactln.equals(actuallastname))
					{
						System.out.println(contactln +"is created");
					}
					else
					{
						System.out.println(contactln +"is not created");
					}
					//td[@id='mouseArea_Organization Name']
					String actualorgname=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
					System.out.println(actualorgname);
					if(actualorgname.trim().equals(orgname))
					{
						System.out.println(orgname +"is created in contacts page");
					}
					else
					{
						System.out.println(orgname +"is not created in contacts page");
					}
					
					
	}

}
