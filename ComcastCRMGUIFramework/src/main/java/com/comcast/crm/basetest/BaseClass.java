package com.comcast.crm.basetest;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.contactobjectrepositoryutility.HomePage;
import com.comcast.crm.contactobjectrepositoryutility.LoginPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.Fileutility;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver;
	//create object
	public Fileutility flib=new Fileutility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBeforeSuite() {
		System.out.println("connect to DB,report config");
	}

	//read data from property file
	/*
	 * @BeforeClass(groups= {"smokeTest","regressionTest"}) public void
	 * congigBeforeClass() throws IOException {
	 * System.out.println("launch browser"); String browser=
	 * flib.getDataFromPropertiesFile("browser");
	 * 
	 * if(browser.equals("chrome")) { driver=new ChromeDriver(); } else
	 * if(browser.equals("firefox")) { driver=new FirefoxDriver(); } else
	 * if(browser.equals("edge")) { driver=new EdgeDriver(); } else { driver=new
	 * ChromeDriver(); } }
	 */
	
	
	//read the browser data from xml file
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void congigBeforeClass() throws IOException {
		System.out.println("launch browser");
//	    String browser=	browsername;	   
	    String b =flib.getDataFromPropertiesFile("browser");
	    if(b.equals("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else if(b.equals("firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }
	    else if(b.equals("edge"))
	    {
	    	driver=new EdgeDriver();
	    }
	    else
	    {
	    	driver=new ChromeDriver();
	    }
	    sdriver=driver;
	    
	}
	
	
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBm() throws IOException {
		System.out.println("login");
	    String url=	flib.getDataFromPropertiesFile("url");
	    String pwd=	flib.getDataFromPropertiesFile("password");
	    String un=	flib.getDataFromPropertiesFile("username");
	    LoginPage lp=new LoginPage(driver);	
		lp.loginToApp(url, pwd, un);
	}
	
 
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAfterClass() {
		System.out.println("close browser");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAfterSuite() {
		System.out.println("close DB,report config");

}
}
