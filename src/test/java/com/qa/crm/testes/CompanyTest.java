package com.qa.crm.testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.CompanyPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.testbase.TestBase;
import com.qa.crm.utilities.TestUtil;

public class CompanyTest extends TestBase{

	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	CompanyPage companyPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		companyPage = homePage.validateCompaniesLink();
	}
	
	@Test(priority = 1)
	public void validateUserLabelTest() {
		boolean flag = companyPage.validateUserLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void selectSingleUserTest() throws InterruptedException {
		companyPage.selectSingleUser("abdul");
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void validateCreateNewCompanyTest() throws InterruptedException {
		homePage.validateHomeLink();
		Thread.sleep(2000);
		homePage.clickOnNewCompanyLink();
		companyPage.verifyNewCompanyDetail("PatelBrothers", "kishanmithil0715@gmail.com");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
