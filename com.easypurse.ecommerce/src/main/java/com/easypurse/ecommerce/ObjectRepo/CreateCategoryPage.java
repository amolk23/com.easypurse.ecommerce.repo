package com.easypurse.ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easypurse.ecommerce.BaseUtility.BaseTest;

public class CreateCategoryPage extends BaseTest {
	
	WebDriver driver;
	public CreateCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "category")
	private WebElement categoryTxtField;
	
	@FindBy(name = "description")
	private WebElement descriptionTxtField;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createBtn;
	
	public WebElement getCategoryTxtField() {
		return categoryTxtField;
	}

	public WebElement getDescriptionTxtField() {
		return descriptionTxtField;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	
	public void createCategory() throws Exception {
	  wlib.maximizetheWindow(driver);
	  wlib.waitPageToload(driver);
	  String category = elib.getDataFromExcel("Category", 1, 0);
	  String Description = elib.getDataFromExcel("Category", 1, 1);
	  getCategoryTxtField().sendKeys(category);
	  getDescriptionTxtField().sendKeys(Description);
	  getCreateBtn().click();
	}
}
