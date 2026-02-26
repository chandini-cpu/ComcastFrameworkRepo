package practice.Asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void homepageTest() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals("home","homepage");
		System.out.println("step4");
		System.out.println("step5");
	}
	
	@Test
	public void verifyHomepageLogoTest() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertTrue(true);
		System.out.println("step4");
		System.out.println("step5");
		
	}



}
