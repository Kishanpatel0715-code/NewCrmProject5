package com.qa.crm.testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.CompanyPage;
import com.qa.crm.pages.ContactPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.testbase.TestBase;
import com.qa.crm.utilities.TestUtil;

public class HomeTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CompanyPage companyPage;
	ContactPage contactPage;
	TestUtil testUtil;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String homePageTitle = homePage.validateHomeTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void validateUpgradeLinkTest() {
		testUtil.switchToFrame();
		boolean flag = homePage.upgradeLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void validateUserLabelTest() {
		testUtil.switchToFrame();
		boolean flag2 = homePage.validateUserLabel();
		Assert.assertTrue(flag2);
	}
	
	@Test(priority = 4)
	public void validateCompaniesLinkTest() {
		testUtil.switchToFrame();
		companyPage = homePage.validateCompaniesLink();
	}
	
	@Test(priority = 5)
	public void validateContactLinkTest() {
		testUtil.switchToFrame();
		contactPage = homePage.validateContactLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
