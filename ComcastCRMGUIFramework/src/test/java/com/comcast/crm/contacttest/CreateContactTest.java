package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.contactobjectrepositoryutility.ContactsPage;
import com.comcast.crm.contactobjectrepositoryutility.CreatingNewContact;
import com.comcast.crm.contactobjectrepositoryutility.HomePage;
import com.comcast.crm.contactobjectrepositoryutility.OrgPageInContacts;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePageOrg;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// read testscript data from excel file

		String lastname = elib.getDataFromExcel("con", 1, 2) + jlib.getRandomNumber();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateConButton().click();

		CreatingNewContact newcon = new CreatingNewContact(driver);
		newcon.getLastname().sendKeys(lastname);
		newcon.getSavebtn().click();

		// verify header orgname information expected result

		String actuallastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (lastname.equals(actuallastname)) {
			System.out.println(lastname + "is created");
		} else {
			System.out.println(lastname + "is not created");
		}
	}

	@Test
	public void createContactOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePageOrg hmo = new HomePageOrg(driver);
		hmo.getOrglink().click();

		// read testscript data from excel file
		String orgname = elib.getDataFromExcel("con", 7, 2) + jlib.getRandomNumber();
		String sadd = elib.getDataFromExcel("con", 7, 5);
		String contactln = elib.getDataFromExcel("con", 7, 3);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateorgbtn().click();

		CreatingNewOrganizationsPage cnew = new CreatingNewOrganizationsPage(driver);
		cnew.enterDetails(orgname, sadd);

		// verify header msg expected result

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
		if (orgname.equals(actualOrgname)) {
			System.out.println(orgname + "is created");
		} else {
			System.out.println(orgname + "is not created");
		}

		// create contact

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// read testscript data from excel file

		String lastname = elib.getDataFromExcel("con", 1, 2) + jlib.getRandomNumber();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateConButton().click();

		CreatingNewContact newcon = new CreatingNewContact(driver);
		newcon.getLastname().sendKeys(lastname);
		String parent = driver.getWindowHandle();
		CreatingNewContact createnew = new CreatingNewContact(driver);
		createnew.getOrgnamebutton().click();
		Thread.sleep(1000);
		wlib.switchToTabOnurl(driver, "module=Accounts");

		OrgPageInContacts org = new OrgPageInContacts(driver);
		org.orgDetails(orgname);

		WebElement link = driver.findElement(By.xpath("//a[text()='" + orgname + "']"));// dynamic xpath
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.elementToBeClickable(link));
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		driver.switchTo().window(parent);

		newcon.getSavebtn().click();

		// verify header orgname information expected result

		String actuallastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (contactln.equals(actuallastname)) {
			System.out.println(contactln + "is created");
		} else {
			System.out.println(contactln + "is not created");
		}
		
		String actualorgname = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		System.out.println(actualorgname);
		if (actualorgname.trim().equals(orgname)) {
			System.out.println(orgname + "is created in contacts page");
		} else {
			System.out.println(orgname + "is not created in contacts page");
		}
	}

	@Test
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// read testscript data from excel file
		String lastname = elib.getDataFromExcel("con", 1, 2) + jlib.getRandomNumber();
		// String sadd=row.getCell(3).toString();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateConButton().click();

		String actualdate = jlib.getSystemDateYYYYDDMM();
		String enddateRequires = jlib.getRequiredDateYYYYDDMM(30); // if we give negative number previous days will get

		CreatingNewContact newcon = new CreatingNewContact(driver);
		newcon.getContactDetails(lastname, actualdate, enddateRequires);
		newcon.getSavebtn().click();

		// verify header orgname information expected result

		String actualstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actualdate.equals(actualstartdate)) {
			System.out.println(actualdate + "is correct");
		} else {
			System.out.println(actualdate + "is not correct");
		}

		String actualenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (enddateRequires.equals(actualenddate)) {
			System.out.println(enddateRequires + "is correct");
		} else {
			System.out.println(enddateRequires + "is not correct");
		}

	}

}
