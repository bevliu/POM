package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	//constructor
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
