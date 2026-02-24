package com.comcast.crm.contactobjectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact 
{
	WebDriver driver;
	public CreatingNewContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savebtn;
	
	@FindBy(name="support_start_date")
	WebElement startdate;
	
	@FindBy(name="support_end_date")
	WebElement enddate;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	WebElement orgnamebutton;
	

	public WebElement getOrgnamebutton() {
		return orgnamebutton;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void getContactDetails(String lastname,String startdate,String enddate)
	{
		getLastname().sendKeys(lastname);
		getStartdate().clear();
		getStartdate().sendKeys(startdate);
		getEnddate().clear();
		getEnddate().sendKeys(enddate);
	}
	

}
