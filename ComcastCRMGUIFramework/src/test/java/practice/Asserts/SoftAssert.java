package practice.Asserts;


import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void homepageTest() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert();
		sa.assertEquals("smaa", "smaaa");
	
		System.out.println("step4");
		System.out.println("step5");
		sa.assertAll();
	}
	
	@Test
	public void verifyHomepageLogoTest() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert();
		sa.assertTrue(true);
		System.out.println("step4");
		System.out.println("step5");
		sa.assertAll();
		
	}

}
