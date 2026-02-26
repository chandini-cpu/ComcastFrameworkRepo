package com.comcast.crm.contactobjectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	WebElement createConButton;
	
	@FindBy(id="dtlview_Last Name")
	WebElement newname;
	

	public WebElement getNewname() {
		return newname;
	}


	public WebElement getCreateConButton() {
		return createConButton;
	}

	
}
