package com.easypurse.ecommerce.AdminModule;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.easypurse.ecommerce.BaseUtility.BaseTest;
import com.easypurse.ecommerce.ObjectRepo.AdminHomePage;
import com.easypurse.ecommerce.ObjectRepo.AdminLoginPage;
import com.easypurse.ecommerce.ObjectRepo.CategoryPage;
import com.easypurse.ecommerce.ObjectRepo.CreateCategoryPage;
import com.easypurse.ecommerce.ObjectRepo.HomePage;
import com.easypurse.ecommerce.ObjectRepo.InsertProductPage;
import com.easypurse.ecommerce.ObjectRepo.subCategoryPage;
import com.easypurse.ecommerce.listenerUtility.ListenerImp;

@Listeners(ListenerImp.class)
public class Admin extends BaseTest {
	


	@Test (groups = "SmokeTest")
	public void adminLogin() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("adminusername");
		String PASSWORD = flib.getDataFromPropertyFile("adminpassword");
		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);
		hp.getAdminLoginLinkTxt().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
		
		String actResult = driver.findElement(By.xpath("//h3[.='Admin Change Password']")).getText();
		String ExpectedResult = "Admin Change Password";
		Assert.assertEquals(actResult,ExpectedResult);
	}


	@Test (groups = "RegressionTest")
	public void createSubCategoryTest() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("adminusername");
		String PASSWORD = flib.getDataFromPropertyFile("adminpassword");
		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);
		hp.getAdminLoginLinkTxt().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
		
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getSubCategoryLink().click();
		
		subCategoryPage scp = new subCategoryPage(driver);
		scp.createSubCategory();
		
		String actText = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(true,actText);
	}
	

	@Test (groups = "RegressionTest")
	public void createCategoryTest() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("adminusername");
		String PASSWORD = flib.getDataFromPropertyFile("adminpassword");
		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);
		hp.getAdminLoginLinkTxt().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
		
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getCreateCategoryLink().click();
		
		CreateCategoryPage ccp = new CreateCategoryPage(driver);
		ccp.createCategory();
		
		String actText = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(true,actText);
	}

}
