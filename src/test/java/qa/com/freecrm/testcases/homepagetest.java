package qa.com.freecrm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.com.freecrm.pages.contactspage;
import qa.com.freecrm.pages.homepage;
import qa.com.freecrm.pages.loginpage;
import qa.com.freecrm.testbase.testbase;
import qa.com.freecrm.util.testutil;

public class homepagetest extends testbase {
	
	loginpage l1;
	homepage h1;
	testutil tu1;
	contactspage c1;

	public homepagetest() {
		super();
	}
	
@BeforeMethod
	
	public void setup() throws IOException, InterruptedException
	{	
		init();
		l1=new loginpage();
		h1=l1.loginusernametest();
		tu1=new testutil();
		c1=new contactspage();		
	}

@Test
public void verifyhomepagetitletest() throws InterruptedException {
	
 String homepagetitle= h1.vrifyhomepagetitle();
 Assert.assertEquals(homepagetitle, "CRMPRO","homepage title not matched");
 
}

@Test
public void verifyusernametest() {
	tu1.switchtoframe();
	Assert.assertTrue(h1.verifycorrectusername());
}
@Test
public void verifycontactslinktest() {
	tu1.switchtoframe();
	c1=h1.clickoncontactslink();
}
@AfterMethod

public void teardown() {
	driver.quit();
}

}
