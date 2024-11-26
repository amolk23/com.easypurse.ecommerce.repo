package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.BaseUtility.BaseTest;

public class myCartPage extends BaseTest {

	WebDriver driver;

	public myCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[.='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckOutBtn;

	@FindBy(name = "billingaddress")
	private WebElement billingAddressTxtField;

	public WebElement getProceedToCheckOutBtn() {
		return proceedToCheckOutBtn;
	}

	public WebElement getBillingAddressTxtField() {
		return billingAddressTxtField;
	}

	public WebElement getBillingStateTxtField() {
		return billingStateTxtField;
	}

	public WebElement getBillingCityTxtField() {
		return billingCityTxtField;
	}

	public WebElement getBillingpinCodeTxtField() {
		return billingpinCodeTxtField;
	}

	public WebElement getUpdatebillingBtn() {
		return updatebillingBtn;
	}

	public WebElement getShippingaddressTxtField() {
		return shippingaddressTxtField;
	}

	public WebElement getShippingstateTxtField() {
		return shippingstateTxtField;
	}

	public WebElement getShippingcityTxtField() {
		return shippingcityTxtField;
	}

	public WebElement getShippingpinCodeTxtField() {
		return shippingpinCodeTxtField;
	}

	public WebElement getUpdateshippingBtn() {
		return updateshippingBtn;
	}

	@FindBy(id = "bilingstate")
	private WebElement billingStateTxtField;

	@FindBy(id = "billingcity")
	private WebElement billingCityTxtField;

	@FindBy(name = "billingpincode")
	private WebElement billingpinCodeTxtField;

	@FindBy(xpath = "//span[text()='Billing Address']/ancestor::table[@class='table table-bordered']/descendant::button[text()='Update']")
	private WebElement updatebillingBtn;

	@FindBy(name = "shippingaddress")
	private WebElement shippingaddressTxtField;

	@FindBy(id = "shippingstate")
	private WebElement shippingstateTxtField;

	@FindBy(id = "shippingcity")
	private WebElement shippingcityTxtField;

	@FindBy(id = "shippingpincode")
	private WebElement shippingpinCodeTxtField;

	@FindBy(xpath = "//span[text()='Shipping Address']/ancestor::table[@class='table table-bordered']/descendant::button[text()='Update']")
	private WebElement updateshippingBtn;

	public void checkOut() throws Exception {
		String shippingAdress = elib.getDataFromExcel("Shipping", 1, 0);
		String shippingState = elib.getDataFromExcel("Shipping", 1, 1);
		String shippingCity = elib.getDataFromExcel("Shipping", 1, 2);
		String shippingPincode = elib.getDataFromExcel("Shipping", 1, 3);

		String billingAdress = elib.getDataFromExcel("Billing", 1, 0);
		String billingState = elib.getDataFromExcel("Billing", 1, 1);
		String billingCity = elib.getDataFromExcel("Billing", 1, 2);
		String billingPincode = elib.getDataFromExcel("Billing", 1, 3);

		getShippingaddressTxtField().clear();
		getShippingaddressTxtField().sendKeys(shippingAdress);
		
		getShippingstateTxtField().clear();
		getShippingstateTxtField().sendKeys(shippingState);
		
		getShippingcityTxtField().clear();
		getShippingcityTxtField().sendKeys(shippingCity);
		
		getShippingpinCodeTxtField().clear();
		getShippingpinCodeTxtField().sendKeys(shippingPincode);
		
//		getUpdateshippingBtn().click();
//		wlib.switchToAlertAndAccept(driver);
		
		getBillingAddressTxtField().clear();
        getBillingAddressTxtField().sendKeys(billingAdress);
        
        getBillingStateTxtField().clear();
		getBillingStateTxtField().sendKeys(billingState);
		
		getBillingCityTxtField().clear();
		getBillingCityTxtField().sendKeys(billingCity);
		
		getBillingpinCodeTxtField().clear();
		getBillingpinCodeTxtField().sendKeys(billingPincode);
		
//		wlib.clickAction(driver, getBillingAddressTxtField());
//		wlib.switchToAlertAndAccept(driver);
		
		wlib.moveToelement(driver, getProceedToCheckOutBtn());
		wlib.clickAction(driver, getProceedToCheckOutBtn());;
	}
}
