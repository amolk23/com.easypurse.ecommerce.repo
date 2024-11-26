package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.GenericUtility.webDriverUtility;

public class HomePage extends webDriverUtility {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
   
	
	@FindBy(linkText = "Home")
	private WebElement homeLinkTxt;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutLinkTxt;
	
	public WebElement getLogoutLinkTxt() {
		return logoutLinkTxt;
	}

	public WebElement getHomeLinkTxt() {
		return homeLinkTxt;
	}


	@FindBy(xpath = "//a[.='My Account']")
	private WebElement myAccountLinkTxt;
	
	@FindBy(xpath = "//a[.='Wishlist']")
	private WebElement wishlistLinkTxt;
	
	@FindBy(xpath = "//a[.='My Cart']")
	private WebElement MyCartLinkTxt;
	
	@FindBy(xpath = "//h2[text()='Shopping']/ancestor::header[@class='header-style-1']/descendant::a[text()='Login']")
	private WebElement LoginLinkTxt;
	
	@FindBy(linkText = "Admin Login")
	private WebElement AdminLoginLinkTxt;
	
	@FindBy(xpath = "//span[text()='Track Order']")
	private WebElement TrackOrderbtn;
	
	@FindBy(xpath = "//input[@class='search-field']")
	private WebElement searchTxtField;
	
	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement searchbtn;
	
	@FindBy(partialLinkText = " Electronics")
	private WebElement ElectronicstLinkTxt;
	
	@FindBy(linkText = " Furniture")
	private WebElement FurnitureLinkTxt;
	
	public WebElement getMyAccountLinkTxt() {
		return myAccountLinkTxt;
	}

	public WebElement getWishlistLinkTxt() {
		return wishlistLinkTxt;
	}

	public WebElement getMyCartLinkTxt() {
		return MyCartLinkTxt;
	}

	public WebElement getLoginLinkTxt() {
		return LoginLinkTxt;
	}

	public WebElement getAdminLoginLinkTxt() {
		return AdminLoginLinkTxt;
	}

	public WebElement getTrackOrderbtn() {
		return TrackOrderbtn;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getElectronicstLinkTxt() {
		return ElectronicstLinkTxt;
	}

	public WebElement getFurnitureLinkTxt() {
		return FurnitureLinkTxt;
	}

	public WebElement getFashionLinkTxt() {
		return FashionLinkTxt;
	}

	public WebElement getMOBILESLinkTxt() {
		return MOBILESLinkTxt;
	}

	public WebElement getWirelessLinkTxt() {
		return WirelessLinkTxt;
	}

	public WebElement getGroceryLinkTxt() {
		return GroceryLinkTxt;
	}

	@FindBy(linkText = " Fashion")
	private WebElement FashionLinkTxt;
	
	@FindBy(linkText = " MOBILES")
	private WebElement MOBILESLinkTxt;
	
	@FindBy(linkText = " WIRELESS")
	private WebElement WirelessLinkTxt;
	
	@FindBy(linkText = " Grocery")
	private WebElement GroceryLinkTxt;
	
	public void launchApp(String url) {
		maximizetheWindow(driver);
		driver.get(url);
	}
	
}
