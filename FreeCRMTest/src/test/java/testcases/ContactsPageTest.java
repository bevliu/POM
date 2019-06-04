package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class ContactsPageTest extends TestBase{

	//constructor
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*test cases should be independent with each other to get better performance
	 *before each test case -- launch the browser and login
	 *@Test -- execute test case
	 *after each test case -- close the browsers
	 */
	
	@BeforeMethod
	//Create login object
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink(); //in HomePage, click on the Contacts link -- return to the ContactsPage
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority = 4)
	public void selectSingleContactsTest() {
		contactsPage.selectContacts("Tom Lin");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContacts("Kit Chen");
		contactsPage.selectContacts("Tom Lin");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateCreateNewConact(String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Chris", "Smith", "Google");
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
