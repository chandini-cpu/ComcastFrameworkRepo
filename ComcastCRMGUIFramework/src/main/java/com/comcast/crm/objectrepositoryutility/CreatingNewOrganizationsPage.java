package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationsPage {
	
	public CreatingNewOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="accountname")
	private WebElement orgnameedt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shipadd;
	
	@FindBy(id="phone")
	private WebElement phno;

	@FindBy(name="industry")
	private WebElement industry;

	@FindBy(name="accounttype")
	private WebElement acctype;
	
	public void industryDropDown(String txt) {
		WebDriverUtility wb=new WebDriverUtility();
		wb.select(txt, industry);
	}
	
	public void accountDropDown(String txt) {
		WebDriverUtility wb=new WebDriverUtility();
		wb.select(txt, acctype);
	}
	
	public WebElement getPhno() {
		return phno;
	}

	public WebElement getOrgnameedt() {
		return orgnameedt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getShipadd() {
		return shipadd;
	}
	
	
	public void enterDetails(String name,String add)
	{
		orgnameedt.sendKeys(name);
		shipadd.sendKeys(add);
		savebtn.click();
	}
	public void enterDetailswithphno(String name,String add,String phnum)
	{
		orgnameedt.sendKeys(name);
		shipadd.sendKeys(add);
		phno.sendKeys(phnum);
		savebtn.click();
	}

}
