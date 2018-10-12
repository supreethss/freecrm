package qa.com.freecrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.com.freecrm.pages.contactspage;
import qa.com.freecrm.pages.homepage;
import qa.com.freecrm.pages.loginpage;
import qa.com.freecrm.testbase.testbase;
import qa.com.freecrm.util.testutil;

public class contactpagetest extends testbase{
	loginpage l1;
	homepage h1;
	testutil tu1;
	contactspage c1;
	String sheetname="contacts";
	
	
	public contactpagetest() {
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException, InterruptedException {
		
			init();
			l1=new loginpage();
			h1=l1.loginusernametest();
			tu1=new testutil();
			c1=new contactspage();
			tu1.switchtoframe();
			c1=h1.clickoncontactslink();
		}
		
		@AfterMethod
		
		public void teardown() {
			driver.quit();
		}
		
		@Test
		public void verifycontactlinktest() {
			
			
			Assert.assertTrue(c1.verifycontactpagelink(),"contacts label is missing on page");
		}
		
		@Test
		public void selectcontactstest() {
			c1.selectcontacts("sandy s");
			c1.selectcontacts("ammu rao");
		}
		
		@DataProvider
		public Object[][] getfreecrmtestdata() {
			Object data [][]=testutil.getTestData(sheetname);
			return data;
			
			
		}
		
		@Test(dataProvider="getfreecrmtestdata")
		public void validatecreatenewcontact(String Title,String ftname,String ltname,String company) throws InterruptedException {
			
			h1.clickonnewcontactlink();
			Thread.sleep(8000);
			c1.createnewcontact(Title,ftname,ltname,company);
		}
}

		

