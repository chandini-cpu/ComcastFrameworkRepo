package practice.listener;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class InvoiceTest 
{
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("execute createInvoice");
		Assert.assertEquals("","login");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		
	}

}
