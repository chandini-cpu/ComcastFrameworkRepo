package practice.listener;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePageOrg;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class SampleTestDebug 
{
	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']"));
		driver.findElement(By.name("accountname")).sendKeys("chans");
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("hyd");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
