package practice.Asserts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshot {
	@Test
	public void ss() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/index.php");
		
		//step1:create object for EventFiringWebDriver class
	    TakesScreenshot ss=(TakesScreenshot)driver;
	    File dest=new File("./screenshot/sample");
	   File f= ss.getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(f, dest);
		
	}

}
