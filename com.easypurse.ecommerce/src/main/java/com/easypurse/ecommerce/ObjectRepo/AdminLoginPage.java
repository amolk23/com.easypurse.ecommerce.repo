package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.GenericUtility.webDriverUtility;

public class AdminLoginPage extends webDriverUtility {
	
	WebDriver driver;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "inputEmail")
	private WebElement emailTxtField;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTxtField;
	
	@FindBy(name = "submit")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[@style='margin-right: 30px;']")
	private WebElement backToPortalBtn;

	public WebElement getBackToPortalBtn() {
		return backToPortalBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
   
	public void adminLogin(String username, String password) {
	
		maximizetheWindow(driver);
		waitPageToload(driver);
		getEmailTxtField().sendKeys(username);
		getPasswordTxtField().sendKeys(password);
		getLoginBtn().click();
	}

}
