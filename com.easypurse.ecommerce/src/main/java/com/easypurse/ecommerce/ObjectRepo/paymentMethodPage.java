package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class paymentMethodPage {

	WebDriver driver;
	public paymentMethodPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement cashOnDeliveryToggle;
	
	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement internateBankingToggle;
	
	@FindBy(xpath = "//input[@value='Debit / Credit card']")
	private WebElement debitcardToggle;
	
	@FindBy(xpath = "//input[@value='submit']")
	private WebElement submitBtn;
	
	public WebElement getCashOnDeliveryToggle() {
		return cashOnDeliveryToggle;
	}

	public WebElement getInternateBankingToggle() {
		return internateBankingToggle;
	}

	public WebElement getDebitcardToggle() {
		return debitcardToggle;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
