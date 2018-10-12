package qa.com.freecrm.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.com.freecrm.pages.loginpage;
import qa.com.freecrm.testbase.testbase;

public class loginpagetest extends testbase{
	
	loginpage l1;
	

	public loginpagetest() throws IOException {
		super();
	}

	@BeforeMethod
	
	public void setup() throws IOException
	{	
		init();
		l1=new loginpage();
		
	}
		
	@Test
	public void validatelogintitletest() {
	String title=l1.validateloginpagetitle();
	System.out.println(title);
	String actual="#1 Free CRM software in the cloud for sales and service";
	String expected="#1 Free CRM software in the cloud for sales and service";
	
	if(actual.equals(expected)) {
		System.out.println("login page text verified");
	}
	
	else
	{
		System.out.println("not verified");
	}
	}
	
	@Test
	public void logintest() throws InterruptedException {
		l1.loginusernametest();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
	
	
	

	
	

		
	


