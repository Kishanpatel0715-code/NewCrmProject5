package com.qa.crm.pages;

//import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.testbase.TestBase;

//import com.qa.crm.testbase.TestBase;

public class LoginPage extends TestBase{

	//object repository
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	public WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	public WebElement signUpBtn;
	
	@FindBy(xpath = "(//img[@class='img-responsive'])[1]")
	public WebElement CrmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCrmLogo() {
		return CrmLogo.isDisplayed();
	}
	
	public HomePage login(String a,String b) {
		username.sendKeys(a);
		password.sendKeys(b);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public SignUpPage validatesignUpButton() {
		signUpBtn.click();
		return new SignUpPage();
	}

}
