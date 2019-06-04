package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[2]/span[1]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactsLink;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[5]/span")
	WebElement dealsLink;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[6]/span")
	WebElement tasksLink;
	
	//Initializing the Page Objects (constructor)
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	//ContactsPage created inside the HomePage
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();  //click on the Contacts link
		return new ContactsPage(); // return to the ContactsPage
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform(); //mouse move to contact link
		newContactLink.click(); //click on new contact
	}

}
