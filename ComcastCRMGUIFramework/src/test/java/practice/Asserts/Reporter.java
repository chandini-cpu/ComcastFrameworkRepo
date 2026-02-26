package practice.Asserts;

import org.testng.annotations.Test;

public class Reporter {
	@Test
	public void homepageTest() {
		org.testng.Reporter.log("step-1",true);
		org.testng.Reporter.log("step2",true);
		org.testng.Reporter.log("step3",true);
	
		org.testng.Reporter.log("step4",true);
		org.testng.Reporter.log("step5",true);
		
	}


}
