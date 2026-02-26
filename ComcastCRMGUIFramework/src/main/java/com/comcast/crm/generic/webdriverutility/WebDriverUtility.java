package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) //if we dont pass the driver instance then it dont understand for which browser it should wait
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement elemnet)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(elemnet));
				
	}
	
	public void switchToTabOnurl(WebDriver driver,String partialURL)
	{
		Set<String> child=driver.getWindowHandles();
		
		  Iterator<String> it=child.iterator();
		  while(it.hasNext()) 
		  { 
		  String winid=it.next(); 
		  driver.switchTo().window(winid);
		  String acturl=driver.getCurrentUrl(); 
		  if(acturl.contains(partialURL)) 
		  {
		  break; 
		  }
		 }
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> child=driver.getWindowHandles();
		
		  Iterator<String> it=child.iterator();
		  while(it.hasNext()) 
		  { 
		  String winid=it.next(); 
		  driver.switchTo().window(winid);
		  String acturl=driver.getCurrentUrl(); 
		  if(acturl.contains(partialTitle)) 
		  {
		  break; 
		  }
		 }
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	  
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
    
	public void mousemoveonElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element);
				
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element);
	}
	
}
