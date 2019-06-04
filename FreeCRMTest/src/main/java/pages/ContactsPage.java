package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ContactsPage extends TestBase{

	//Initializing the Page Objects (constructor)
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	//@FindBy(xpath = "//td[contains(text(),'Deals Base')]")
	//WebElement checkBox;
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	//generic method
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
	}
	
	public void createNewContact(String fName, String lName, String comp) {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		
		saveBtn.click();
	}

}
