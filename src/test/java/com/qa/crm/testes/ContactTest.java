package com.qa.crm.testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.testbase.TestBase;
import com.qa.crm.utilities.TestUtil;

public class ContactTest extends TestBase{
	
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	ContactPage contactPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.validateContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateContactLogoTest() {
		boolean flag = contactPage.validateContactLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateSingleUserTest() throws InterruptedException {
		contactPage.validateSingleUserClick("Ajay Sharma");
		Thread.sleep(2000);
	}
	
	@Test
	public void validateMultipleUserTest() throws InterruptedException {
		contactPage.validateSingleUserClick("Ajay Sharma");
		contactPage.validateSingleUserClick("akash patel");
		Thread.sleep(2000);
		
	}
	
	@Test
	public void validateNewContactTest() throws InterruptedException {
		homePage.validateHomeLink();
		Thread.sleep(2000);
		homePage.clickOnNewContactLink();
		contactPage.verifyNewContactUser("Mrs.", "nirali", "patel", "nilu", "Admin");
		
		Thread.sleep(2000);
		homePage.clickOnNewContactLink();
		contactPage.verifyNewContactUser("Mr.", "kishan", "patel", "kishu", "Manager");
	
		Thread.sleep(2000);
		homePage.clickOnNewContactLink();
		contactPage.verifyNewContactUser("Mr.", "Jay", "patel", "Jalu", "Employee");
	
	}
}
