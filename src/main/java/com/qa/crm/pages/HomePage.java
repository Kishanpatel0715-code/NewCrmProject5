package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.testbase.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	public WebElement UserLabel;
	
	@FindBy(linkText = "Upgrade your account")
	public WebElement upgradeLink;
	
	@FindBy(xpath = "//a[contains(text(),'Companies')]")
	public WebElement companiesLink;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Company')]")
	public WebElement newCompanyLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	public WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homeLink;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateHomeTitle() {
		return driver.getTitle();
	}
	
	public boolean upgradeLink() {
		return upgradeLink.isDisplayed();
	}
	
	public boolean validateUserLabel() {
		return UserLabel.isDisplayed();
	}
	
	public CompanyPage validateCompaniesLink() {
		companiesLink.click();
		return new CompanyPage();
	}
	
	public ContactPage validateContactLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public void clickOnNewCompanyLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(companiesLink).build().perform();
		newCompanyLink.click();	
	}
	
	public void validateHomeLink() {
		homeLink.click();
	}
	
	public void clickOnNewContactLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsLink).build().perform();
		newContactLink.click();	
	}
}
