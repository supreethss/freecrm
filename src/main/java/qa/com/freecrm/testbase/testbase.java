package qa.com.freecrm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.com.freecrm.util.testutil;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	 
	 
	 public testbase()  {
		 
		 try {

		 prop=new Properties();
		 FileInputStream ip=new FileInputStream("D:\\framework\\freecrmmaven\\src\\main\\java\\qa\\com\\freecrm\\config\\config.properties");
		 prop.load(ip);
	 }catch (FileNotFoundException e) {
		 e.printStackTrace();
	 }catch (IOException e) {
		 e.printStackTrace();
	 }
	 }
	 public static void init() {
		String browsername= prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\framework\\freecrmmaven\\browser\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(testutil.Page_Load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testutil.implicit_wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
	
	 }
	
	

}
