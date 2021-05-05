package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.testbase.TestBase;

public class CompanyPage extends TestBase{
	//object repository
	@FindBy(xpath="//td[contains(text(),'Companies')]")
	public WebElement UserLabel;
	
	@FindBy(id = "company_name")
	public WebElement companyName;
	
	@FindBy(id = "email")
	public WebElement emailId;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	public WebElement saveBtn;
	
	public CompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public boolean validateUserLabel() {
		return UserLabel.isDisplayed();
	}
	
	public void selectSingleUser(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling[@class='datalistrow']//input[@name='client_id']")).click();	
	}
	
	public void verifyNewCompanyDetail(String com,String email) throws InterruptedException {
		
		companyName.sendKeys(com);
		emailId.sendKeys(email);
		saveBtn.click();
		
	}
	
	
	
}
