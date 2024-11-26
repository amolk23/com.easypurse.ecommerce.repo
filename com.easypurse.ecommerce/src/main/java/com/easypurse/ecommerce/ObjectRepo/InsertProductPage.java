package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {
	
	WebDriver driver;
	public InsertProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "category")
	private WebElement categoryDD;
	
	@FindBy(id = "subcategory")
	private WebElement subcategoryDD;
	
	@FindBy(name = "productName")
	private WebElement productNameTxtField;
	
	@FindBy(name = "productCompany")
	private WebElement productCompanyTxtField;
	
	@FindBy(name = "productpricebd")
	private WebElement productPriceBDTxtfield;
	
	@FindBy(name = "productprice")
	private WebElement productPriceADTxtField;
	
	@FindBy(xpath = "//div[@class=' nicEdit-main']")
	private WebElement productDescriptionTxtField;
	
	@FindBy(name = "productShippingcharge")
	private WebElement productShippingTxtField;
	
	@FindBy(id = "productAvailability")
	private WebElement productAvailabilityDD;
	
	@FindBy(xpath = "//button[text()='Insert']")
	private WebElement insertBtn;
	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubcategoryDD() {
		return subcategoryDD;
	}

	public WebElement getProductNameTxtField() {
		return productNameTxtField;
	}

	public WebElement getProductCompanyTxtField() {
		return productCompanyTxtField;
	}

	public WebElement getProductPriceBDTxtfield() {
		return productPriceBDTxtfield;
	}

	public WebElement getProductPriceADTxtField() {
		return productPriceADTxtField;
	}

	public WebElement getProductDescriptionTxtField() {
		return productDescriptionTxtField;
	}

	public WebElement getProductShippingTxtField() {
		return productShippingTxtField;
	}

	public WebElement getProductAvailabilityDD() {
		return productAvailabilityDD;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}

}
