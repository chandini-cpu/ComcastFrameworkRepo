package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageOrg {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	WebElement orglink;
	
	@FindBy(linkText="Products")
	WebElement productLink;
	
	public WebElement getProductLink() {
		return productLink;
	}

	public HomePageOrg(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrglink() {
		return orglink;
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
