package qa.com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.com.freecrm.testbase.testbase;

public class contactspage extends testbase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement prefix;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
	public contactspage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactpagelink() {
		return contacts.isDisplayed();
	}
	
	public void selectcontacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createnewcontact(String Title,String ftname,String ltname,String comp) {
	    Select sel=new Select(prefix);
	    sel.selectByVisibleText(Title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		save.click();
		
		
		
	}
		
	}


