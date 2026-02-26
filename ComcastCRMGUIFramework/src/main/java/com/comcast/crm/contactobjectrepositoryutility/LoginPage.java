package com.comcast.crm.contactobjectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{
	//Rule 2object creation
		@FindBy(name="user_name")
		WebElement usernameedt;
		
		@FindBy(name="user_password")
		WebElement passwordedt;
		
		@FindBy(id="submitButton")
		WebElement loginbtn;
		
		WebDriver driver;
		/**
		 * contains login to application
		 * @param driver
		 */
		public LoginPage(WebDriver driver) {    //driver is local to this constructor we cannot use it anywhere inorder to use it
			//we declare the driver as global and initialise in the constructor
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		
		//Rule 3 object initialization
		
		//Rule 4 object encapsulation
		public WebElement getUsernameedt() {
			return usernameedt;
		}

		public WebElement getPasswordedt() {
			return passwordedt;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
		
		//provide action
		public void loginToApp(String url,String un,String pwd)
		{
			
			driver.get(url);
			waitForPageToLoad(driver);
			driver.manage().window().maximize();
			usernameedt.sendKeys(un);
			passwordedt.sendKeys(pwd);
			loginbtn.click();
		}

		

}
