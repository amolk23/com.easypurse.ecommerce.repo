package com.easypurse.ecommerce.ObjectRepo;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.GenericUtility.webDriverUtility;

public class UserLoginPage extends webDriverUtility{

	WebDriver driver;

	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "fullname")
	private WebElement fullnameTxtField;

	@FindBy(id = "email")
	private WebElement emailTxtField;

	@FindBy(id = "contactno")
	private WebElement contactnoTxtField;

	@FindBy(id = "password")
	private WebElement passwordTxtField;
	
	@FindBy(id = "confirmpassword")
	private WebElement confirmPassTxtField;

	public WebElement getConfirmPassTxtField() {
		return confirmPassTxtField;
	}

	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpbtn;

	@FindBy(id = "exampleInputEmail1")
	private WebElement email;

	@FindBy(id = "exampleInputPassword1")
	private WebElement password;

	@FindBy(linkText = "Forgot your Password?")
	private WebElement forgotPasswordLinTxt;

	@FindBy(xpath = "//button[.='Login']")
	private WebElement loginBtn;

	public WebElement getFullnameTxtField() {
		return fullnameTxtField;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getContactnoTxtField() {
		return contactnoTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getSignUpbtn() {
		return signUpbtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getForgotPasswordLinTxt() {
		return forgotPasswordLinTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void userLogin(String username, String password) throws Exception {
		maximizetheWindow(driver);
		waitPageToload(driver);
		getEmail().sendKeys(username);
		getPassword().sendKeys(password,Keys.ENTER);
//		waitForElementPresent(driver, getLoginBtn());
//		executeScript(driver, "window.scrollTo(0,500)", getLoginBtn());
//		scrollToElement(driver, getLoginBtn());
		//Thread.sleep(3000);
		//getLoginBtn().click();
	}

}
