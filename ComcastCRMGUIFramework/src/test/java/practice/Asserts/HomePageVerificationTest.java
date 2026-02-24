package practice.Asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerificationTest
{
	@Test
	public void homepageTest() {
		String expected="Home page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actual=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		if(expected.equals(actual))
		{
			System.out.println(expected +"is verified");
		}
		else
		{
			System.out.println(expected+"not verified");
		}
	}
	
	@Test
	public void verifyHomepageLogoTest() {
		//String expected="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
		if(status)
		{
			System.out.println("logo is verified");
		}
		else
		{
			System.out.println("logo is not verified");
		}
		
	}

}
