package com.comcast.crm.orgtestConfig;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePageOrg;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganisationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		HomePageOrg hp = new HomePageOrg(driver);
		hp.getOrglink().click();

		// read testscript data from excel file
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2) + jlib.getRandomNumber();
		String sadd = elib.getDataFromExcel("Sheet1", 1, 3) + jlib.getRandomNumber();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateorgbtn().click();
		CreatingNewOrganizationsPage neworg = new CreatingNewOrganizationsPage(driver);
		neworg.enterDetails(orgname, sadd);
		// verify header msg expected result
		// WebElement
		// header=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dvHeaderText']")));
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgname)) {
			System.out.println(orgname + "is created");
		} else {
			System.out.println(orgname + "is not created");
		}
		// verify header orgname information expected result

		String actualOrgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (headerInfo.equals(actualOrgname)) {
			System.out.println(orgname + "is created");
		} else {
			System.out.println(orgname + "is not created");
		}
	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNo() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePageOrg hp = new HomePageOrg(driver);
		hp.getOrglink().click();

		// read testscript data from excel file

		String orgname = elib.getDataFromExcel("Sheet1", 7, 2) + jlib.getRandomNumber();
		String sadd = elib.getDataFromExcel("Sheet1", 7, 3);
		String pj = elib.getDataFromExcel("Sheet1", 7, 6);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateorgbtn().click();
		CreatingNewOrganizationsPage neworg = new CreatingNewOrganizationsPage(driver);
		neworg.enterDetailswithphno(orgname, sadd, pj);

		Thread.sleep(1000);
		// validation

		String fg = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		if (fg.equals(pj)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustries() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePageOrg hp = new HomePageOrg(driver);
		hp.getOrglink().click();

		// read testscript data from excel file
		String orgname = elib.getDataFromExcel("Sheet1", 4, 2) + jlib.getRandomNumber();
		String sadd = elib.getDataFromExcel("Sheet1", 4, 3);
		String industry = elib.getDataFromExcel("Sheet1", 4, 4);
		String type = elib.getDataFromExcel("Sheet1", 4, 5);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateorgbtn().click();
		CreatingNewOrganizationsPage neworg = new CreatingNewOrganizationsPage(driver);
		neworg.industryDropDown(industry);
		neworg.accountDropDown(type);
		neworg.enterDetails(orgname, sadd);
		Thread.sleep(1000);
		// validation
		if (driver.findElement(By.id("dtlview_Industry")).getText().equals(industry)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		if (driver.findElement(By.id("dtlview_Type")).getText().equals(type)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

}
