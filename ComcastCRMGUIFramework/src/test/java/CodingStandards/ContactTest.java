package CodingStandards;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.contactobjectrepositoryutility.HomePage;
import com.comcast.crm.contactobjectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author srinivasa rao
 */
public class ContactTest extends BaseClass
{
	@Test
	public void searchContact() {
		/*login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("url", "chand", "123");
		
		/*click on contact module*/
		HomePage hp=new HomePage(driver);
		hp.getContactlink();
		
		
	}

}
