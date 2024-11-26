package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.BaseUtility.BaseTest;


public class subCategoryPage extends BaseTest{
	
	WebDriver driver;
	public subCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
    @FindBy(name = "category")
    private WebElement categoryTxtField;
    
    @FindBy(xpath = "//input[@name='subcategory']")
    private WebElement subCategoryTxtField;
    
    @FindBy(xpath = "//button[.='Create']")
    private WebElement createBtn;
    
	public WebElement getCategoryTxtField() {
		return categoryTxtField;
	}

	public WebElement getSubCategoryTxtField() {
		return subCategoryTxtField;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}
    
	public void createSubCategory() throws Exception {
		wlib.maximizetheWindow(driver);
	    wlib.waitPageToload(driver);
		String category = elib.getDataFromExcel("Subcategory", 1, 0);
		String Subcategory = elib.getDataFromExcel("Subcategory", 1, 1);
		wlib.selectByVisibleText(getCategoryTxtField(), category);
		getSubCategoryTxtField().sendKeys(Subcategory);
		getCreateBtn().click();
		
	}
    
}
