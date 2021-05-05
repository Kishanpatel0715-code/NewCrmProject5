package com.qa.crm.testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.testbase.TestBase;

public class LoginTest extends TestBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	SignUpPage signupPage = new SignUpPage();
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		String actual = loginPage.validateTitle();
		Assert.assertEquals(actual, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void validateCrmLogo() {
		boolean flag = loginPage.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 4)
	public void validateSignUpTest() {
		signupPage = loginPage.validatesignUpButton();
	}
}
