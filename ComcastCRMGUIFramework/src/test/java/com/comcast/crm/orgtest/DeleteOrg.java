package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePageOrg;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class DeleteOrg {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		Fileutility flib = new Fileutility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
        WebDriverUtility wlib=new WebDriverUtility();
       
		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");

		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		/*
		 * LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		 * 
		 * lp.getUsernameedt().sendKeys("admin"); lp.getPasswordedt().sendKeys("admin");
		 * lp.getLoginbtn().click();
		 * 
		 * lp.loginToApp("admin", "admin");
		 */

		// this is not suitable because if we have 500 pages to access all the pages we
		// need to write this
		// LoginPage lp=PageFactory.initElements(driver, LoginPage.class); again and
		// again .so to avoid this we use
		// constructor so that in script we create object for the page class and
		// automatically the constructor get invoked
		// when object is created so the page will be called
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url,username, password);
		
		//navigate to orgisation page
		HomePageOrg hm=new HomePageOrg(driver);
		hm.getOrglink().click();
		
		//create organization
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateorgbtn().click();
		
		
		 //read testscript data from excel file
		 String orgname= elib.getDataFromExcel("Sheet1", 10, 2)+jlib.getRandomNumber();		 
		 String sadd=elib.getDataFromExcel("Sheet1", 10, 3)+jlib.getRandomNumber();
		 
		//create new org page
		CreatingNewOrganizationsPage cnew=new CreatingNewOrganizationsPage(driver);
		cnew.enterDetails(orgname, sadd);
		
		//validate the orgname
		OrganizationInformationPage oinfopage=new OrganizationInformationPage(driver);
		Thread.sleep(1000);
		String actualOrgName=oinfopage.getHeadermsg().getText();
		if(actualOrgName.contains(orgname))
		{
			System.out.println(orgname +"is verified");
		}
		else
		{
			System.out.println(orgname +"is  not verified");
		}
		
		//go back to org page
	
		hm.getOrglink().click();
		
		//search for org
		op.getSearchtxt().sendKeys(orgname);
		wlib.select("Organization Name",op.getDropdwn());
		op.getSearchbtn().click();
		Thread.sleep(1000);
		//in dynamic webtable select and delete the org
		driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]/../../descendant::a[text()='del']")).click();
		wlib.switchToAlertAccept(driver);
		
		
		//logout
		hm.logout();
		driver.quit();
	}
}
