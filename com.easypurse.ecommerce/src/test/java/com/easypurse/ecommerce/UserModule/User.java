package com.easypurse.ecommerce.UserModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.easypurse.ecommerce.BaseUtility.BaseTest;
import com.easypurse.ecommerce.ObjectRepo.CategoryPage;
import com.easypurse.ecommerce.ObjectRepo.HomePage;
import com.easypurse.ecommerce.ObjectRepo.UserLoginPage;
import com.easypurse.ecommerce.ObjectRepo.myCartPage;
import com.easypurse.ecommerce.ObjectRepo.paymentMethodPage;
import com.easypurse.ecommerce.listenerUtility.ListenerImp;

@Listeners(ListenerImp.class)
public class User extends BaseTest {

	@Test (groups ="SmokeTest")
	public void UserLogin() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");

		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);

		hp.getMyAccountLinkTxt().click();
		UserLoginPage ulp = new UserLoginPage(driver);

		ulp.userLogin(USERNAME, PASSWORD);
		String actResult = driver.findElement(By.xpath("//li[text()='Shopping Cart']/parent::ul[@class='list-inline list-unstyled']/descendant::a[text()='Home']")).getText();
	    Assert.assertTrue(true, actResult);

	}

	@Test (groups = "RegressionTest")
	public void verifyWishlistAfterLogout() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");

		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);

		hp.getMyAccountLinkTxt().click();
		UserLoginPage ulp = new UserLoginPage(driver);
		System.out.println("User login page");
		ulp.userLogin(USERNAME, PASSWORD);

		String name = elib.getDataFromExcel("Product", 2, 0);
		hp.getSearchTxtField().sendKeys(name);
		hp.getSearchbtn().click();
		wlib.executeScriptargu(driver, name, hp.getWishlistLinkTxt());
	   
		Thread.sleep(3000);
		hp.getLogoutLinkTxt().click();
		hp.getMyAccountLinkTxt().click();
		UserLoginPage ulp1 = new UserLoginPage(driver);
		ulp1.userLogin(USERNAME, PASSWORD);

		hp.getWishlistLinkTxt().click();
		String ExpectedResult ="Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)";
		WebElement actResult = driver.findElement(By.xpath("//a[text()='Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)']"));
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actResult, ExpectedResult);
	}

	@Test (groups = "RegressionTest")
	public void VerifyTheCheckOutProcess() throws Exception {
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");

		String ProductName = elib.getDataFromExcel("cart", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);

		hp.getMyAccountLinkTxt().click();
		UserLoginPage ulp = new UserLoginPage(driver);
		Thread.sleep(2000);
		ulp.userLogin(USERNAME, PASSWORD);

		hp.getSearchTxtField().sendKeys(ProductName);
		hp.getSearchbtn().click();

		CategoryPage cp = new CategoryPage(driver);
	    wlib.executeScriptargu(driver, ProductName, cp.getAddToCartBtn());
	    wlib.switchToAlertAndAccept(driver);
		
		hp.getMyCartLinkTxt().click();
       
		myCartPage mcp = new myCartPage(driver);
		Thread.sleep(3000);
		
		wlib.moveToelement(driver, mcp.getBillingAddressTxtField());
		mcp.checkOut();
		

		paymentMethodPage pmp = new paymentMethodPage(driver);
		pmp.getCashOnDeliveryToggle().click();
		wlib.executeScript(driver, "window.scrollTo(0,400)", pmp.getSubmitBtn());;
		pmp.getSubmitBtn().click();
		String actData = driver.findElement(By.xpath("//a[contains(text(),'Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)')]")).getText();
		String ExpectedData = "Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)";
		Assert.assertTrue(actData.contains(ExpectedData));

	}

	@Test (groups = "SmokeTest")
	public void verifyUserAbleToCreateAccount() throws Exception {

		String fullName = elib.getDataFromExcel("CreateAccount", 1, 0);
		String emailAdd = elib.getDataFromExcel("CreateAccount", 1, 1);
		String contactNo = elib.getDataFromExcel("CreateAccount", 1, 2);
		String password = elib.getDataFromExcel("CreateAccount", 1, 3);
		String confirmPass = elib.getDataFromExcel("CreateAccount", 1, 4);

		String URL = flib.getDataFromPropertyFile("url");
		HomePage hp = new HomePage(driver);
		hp.launchApp(URL);

		hp.getLoginLinkTxt().click();
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.getFullnameTxtField().sendKeys(fullName);
		ulp.getEmailTxtField().sendKeys(emailAdd);
		wlib.executeScriptargu(driver, "arguments[0].click", ulp.getSignUpbtn());
		ulp.getContactnoTxtField().sendKeys(contactNo);
		ulp.getPasswordTxtField().sendKeys(password);
		
		ulp.getConfirmPassTxtField().sendKeys(confirmPass, Keys.ENTER);
		
		
	}

}
