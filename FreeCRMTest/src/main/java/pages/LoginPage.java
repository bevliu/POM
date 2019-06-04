package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository:
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement signinBtn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement signupBtn;
	
	
	//Initializing the Page Objects (constructor)
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	//Return to HomePage as an object
	public HomePage login(String un, String pwd) throws IOException {
		signinBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

	
	
	
}