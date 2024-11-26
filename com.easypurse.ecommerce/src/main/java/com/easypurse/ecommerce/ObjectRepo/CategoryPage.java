package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[.='Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)']/parent::h3/parent::div/following-sibling::div//a[@title='Wishlist']")
	private WebElement wishlisticon;
	
    @FindBy(xpath = "//a[text()='Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)']/ancestor::div[@class='product']/descendant::button[text()='Add to cart']")
    private WebElement addToCartBtn;
    
    
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getWishlisticon() {
		return wishlisticon;
	}
	
	
	

}
