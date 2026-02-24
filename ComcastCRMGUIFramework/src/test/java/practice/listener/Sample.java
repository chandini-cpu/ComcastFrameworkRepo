package practice.listener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.basetest.BaseClasss;

import junit.framework.Assert;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass2.class)
public class Sample extends BaseClass
{
	@Test
	public void createInvoiceTest() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "login");
		//Assert.assertTrue(false);
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("step5");
	}
	

}
