package qa.com.freecrm.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.com.freecrm.pages.contactspage;
import qa.com.freecrm.pages.dealspage;
import qa.com.freecrm.pages.homepage;
import qa.com.freecrm.pages.loginpage;
import qa.com.freecrm.testbase.testbase;
import qa.com.freecrm.util.testutil;

public class dealspagetest extends testbase{
	
	loginpage l1;
	homepage h1;
	testutil tu1;
	dealspage dp1;
	String sheetname="deals";
	
	public dealspagetest() {
		super();
	}
	
	@DataProvider
	public Object[][] getfreecrmtestdata() {
		Object data [][]=testutil.getTestData(sheetname);
		return data;
	}
	@BeforeMethod
	
	public void setup() throws IOException, InterruptedException {
		
			init();
			l1=new loginpage();
			h1=l1.loginusernametest();
			dp1=new dealspage();
			tu1=new testutil();
			tu1.switchtoframe();
}
	@Test(dataProvider="getfreecrmtestdata")
	public void dealspagetest(String title,String company,String pc,String amount) throws InterruptedException {
		h1.clickonnewdeal();
		Thread.sleep(5000);
		dp1.clickonnewdeal(title,company,pc,amount);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
