package com.comcast.crm.contactobjectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText="Contacts")
	WebElement contactlink;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	WebElement logout;
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		logout.click();
		
	}
	

}
