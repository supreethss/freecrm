package qa.com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.freecrm.testbase.testbase;

public class dealspage extends testbase {
	
	@FindBy(xpath="//input[@id='title']")
	WebElement dealstitle;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement dealscompany;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement dealsprimarycontact;
	
	@FindBy(xpath="//input[@name='amount']")
	WebElement dealsamount;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save and Create Another' and @class='button']")
	WebElement saveandcreateanother;
	
    public dealspage() {
    	PageFactory.initElements(driver, this);
    }
    
    public void clickonnewdeal(String title,String company,String pc,String amount) {
    	dealstitle.sendKeys(title);
    	dealscompany.sendKeys(company);
    	dealsprimarycontact.sendKeys(pc);
    	dealsamount.sendKeys(amount);
    	saveandcreateanother.click();
    }
}
