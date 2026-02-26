package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgbtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	WebElement searchtxt;
	
	@FindBy(xpath="//select[@name='search_field']")
	WebElement dropdwn;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement searchbtn;

	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getDropdwn() {
		return dropdwn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
//	public void searchorgname(String search) {
//		searchtxt.sendKeys(search);
//		Select sel=new Select(dropdwn);
//		sel.selectByVisibleText("Organization Name");
//		searchbtn.click();
//	}
//	
	
	
	

}
