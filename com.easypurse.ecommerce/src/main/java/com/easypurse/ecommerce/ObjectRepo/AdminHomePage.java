package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@class='collapsed']")
	private WebElement orderManagementLink;
	
	@FindBy(xpath = "//i[@class='menu-icon icon-group']")
	private WebElement manageUsersLink;
	
	@FindBy(xpath = "//a[.=' Create Category ']")
	private WebElement createCategoryLink;
	
	public WebElement getOrderManagementLink() {
		return orderManagementLink;
	}

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}

	public WebElement getCreateCategoryLink() {
		return createCategoryLink;
	}

	public WebElement getSubCategoryLink() {
		return subCategoryLink;
	}

	public WebElement getInsertProductLink() {
		return insertProductLink;
	}

	public WebElement getManageProductLink() {
		return manageProductLink;
	}

	public WebElement getUserLoginLogLink() {
		return userLoginLogLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	@FindBy(xpath = "//a[text()='Sub Category ']")
	private WebElement subCategoryLink;
	
	@FindBy(xpath = "//a[text()='Insert Product ']")
	private WebElement insertProductLink;
	
	@FindBy(xpath = "//a[text()='Manage Products ']")
	private WebElement manageProductLink;
	
	@FindBy(xpath = "//a[text()='User Login Log ']")
	private WebElement userLoginLogLink;
	
	@FindBy(xpath = "//i[@class='menu-icon icon-signout']")
	private WebElement logoutLink;
	
	

}
