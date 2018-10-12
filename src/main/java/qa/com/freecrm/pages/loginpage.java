package qa.com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.freecrm.testbase.testbase;

public class loginpage extends testbase{
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//div[@class='input-group-btn']//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.html'] ")
	WebElement crmlogo;

	public loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMimage() {
		 return crmlogo.isDisplayed();
		
	}
	public homepage loginusernametest() throws InterruptedException {
		username.sendKeys("supreethS");
		password.sendKeys("SUPREE@230792");
		Thread.sleep(5000);
		loginbutton.click();
		return new homepage();
	}

}


