package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.testbase.TestBase;

public class ContactPage extends TestBase{

	//page factories
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	public WebElement contactLogo;
	
	@FindBy(id = "first_name")
	public WebElement firstname;
	
	@FindBy(name = "surname")
	public WebElement lastname;
	
	@FindBy(name = "nickname")
	public WebElement nickName;
	
	@FindBy(name = "company_position")
	public WebElement position;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	public WebElement saveBtn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public boolean validateContactLogo() {
		return contactLogo.isDisplayed();
	}
	
	public void validateSingleUserClick(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//"
				+ "preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void verifyNewContactUser(String title,String fname,String lname,String nName,String pos) {
		Select s = new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		nickName.sendKeys(nName);
		position.sendKeys(pos);
		
		saveBtn.click();
	
		
		
	}
}
