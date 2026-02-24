package com.comcast.crm.contactobjectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPageInContacts 
{
	WebDriver driver;
	public OrgPageInContacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='search_txt']")
	WebElement search;
	
	@FindBy(xpath="//input[@type='button']")
	WebElement searchbtn;
	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public void orgDetails(String orgname)
	{
		getSearch().sendKeys(orgname);
		getSearchbtn().click();
		
	}

}
