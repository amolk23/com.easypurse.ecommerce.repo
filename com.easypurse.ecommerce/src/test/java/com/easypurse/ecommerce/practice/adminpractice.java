package com.easypurse.ecommerce.practice;

import org.testng.annotations.Test;

import com.easypurse.ecommerce.BaseUtility.BaseTest;
import com.easypurse.ecommerce.ObjectRepo.AdminHomePage;
import com.easypurse.ecommerce.ObjectRepo.AdminLoginPage;
import com.easypurse.ecommerce.ObjectRepo.HomePage;
import com.easypurse.ecommerce.ObjectRepo.InsertProductPage;

public class adminpractice extends BaseTest {
	
	@Test
	public void verifyAdminAddNewProductTest() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("adminusername");
		String PASSWORD = flib.getDataFromPropertyFile("adminpassword");
		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);
		hp.getAdminLoginLinkTxt().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getInsertProductLink().click();

		InsertProductPage ipp = new InsertProductPage(driver);
		String category = elib.getDataFromExcel("Product", 1, 0);
		String subcategory = elib.getDataFromExcel("Product", 1, 1);
		String productName = elib.getDataFromExcel("Product", 1, 2);
		String productCompany = elib.getDataFromExcel("Product", 1, 3);
		String productpriceBD = elib.getDataFromExcel("Product", 1, 4);
		String productpriceAD = elib.getDataFromExcel("Product", 1, 5);
		String productDescription = elib.getDataFromExcel("Product", 1, 6);
		String productshippingCharge = elib.getDataFromExcel("Product", 1, 7);
		String productAvailability = elib.getDataFromExcel("Product", 1, 8);
		
		wlib.selectByVisibleText(ipp.getCategoryDD(), category);
		wlib.selectByVisibleText(ipp.getSubcategoryDD(), subcategory);
		ipp.getProductNameTxtField().sendKeys(productName);
		ipp.getProductCompanyTxtField().sendKeys(productCompany);
		ipp.getProductPriceBDTxtfield().sendKeys(productpriceBD);
		ipp.getProductPriceADTxtField().sendKeys(productpriceAD);
		ipp.getProductDescriptionTxtField().sendKeys(productDescription);
		ipp.getProductShippingTxtField().sendKeys(productshippingCharge);
		wlib.deselectByVisibleText(ipp.getProductAvailabilityDD(), productAvailability);
		ipp.getInsertBtn().click();

	}
}
