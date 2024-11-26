package com.easypurse.ecommerce.BaseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.easypurse.ecommerce.DatabaseUtility.DatabaseUtility;
import com.easypurse.ecommerce.GenericUtility.UtilityObject;
import com.easypurse.ecommerce.GenericUtility.webDriverUtility;
import com.easypurse.ecommerce.fileUtility.ExcelUtility;
import com.easypurse.ecommerce.fileUtility.FileUtility;

public class BaseTest {
	public WebDriver driver;
	public static WebDriver sdriver = null;
	public FileUtility flib = new FileUtility();
	public webDriverUtility wlib = new webDriverUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DatabaseUtility dlib = new DatabaseUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		//connect to database
		dlib.getConnection();
	}
    
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void ConfigBC(@Optional("chrome") String browser) throws Exception {
		//launch browser
	 String BROWSER = flib.getDataFromPropertyFile("browser");
	 //String BROWSER = System.getProperty("browser");
	 System.out.println("Browser:"+BROWSER);
	 if (BROWSER.equals("chrome")) {
	    driver = new ChromeDriver();
	 }else if (BROWSER.equals("edge")) {
		 driver = new EdgeDriver();
	}else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	}else {
		driver = new ChromeDriver();
	}
	 sdriver= driver;
	 UtilityObject.setDriver(driver);
}
		
	
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() {
		//login
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		//logout
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		//close the browser
		driver.quit();
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void configAS() {
		//close database connection
		dlib.closeConnection();
	}
}
