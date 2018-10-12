package qa.com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.freecrm.config.taskspage;
import qa.com.freecrm.testbase.testbase;

public class homepage extends testbase {
	
	@FindBy(xpath="//td[contains(text(),'User: SUPREETH S')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newcontacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[text()='New Deal']")
	WebElement newdealslink;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;

     
    public homepage() {
    	PageFactory.initElements(driver, this);
    	
    }
    
    public String vrifyhomepagetitle() {
    	
    	return driver.getTitle();
    }
    
    public contactspage clickoncontactslink() {
    	contactslink.click();
    	return new contactspage();
    }
    
    public dealspage clickondealslink() {
    	dealslink.click();
    	return new dealspage();
    }
    
    public taskspage clickontaskslink() {
    	taskslink.click();
    	return new taskspage();
    }
    
    public boolean verifycorrectusername() {
    	return usernamelabel.isDisplayed();
    }
    public void clickonnewcontactlink() {
    	Actions act=new Actions(driver);
    	act.moveToElement(contactslink).build().perform();
    	newcontacts.click();
    }
    
    public void clickonnewdeal() {
    	Actions act=new Actions(driver);
    	act.moveToElement(dealslink).build().perform();
    	newdealslink.click();
    	
    }
}

