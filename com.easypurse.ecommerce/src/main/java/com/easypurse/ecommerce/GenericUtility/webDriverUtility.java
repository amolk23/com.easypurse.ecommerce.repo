package com.easypurse.ecommerce.GenericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {
	
	
	public void maximizetheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitPageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void waitForElementPresent(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void switchToTabOnUrl(WebDriver driver,String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameId) {
		driver.switchTo().frame(nameId);
	}
	
	public void switchToFrame(WebDriver driver,WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	
	public void moveToelement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public void clickAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele).build().perform();;
		
	}
	
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public void dragAndDropsrcTodest(WebDriver driver,WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	public void dragAndDroponAxex(WebDriver driver,WebElement src, int xpixel, int ypixel) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, xpixel, ypixel).perform();
	}
	
	public void scrollToElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	public void selectByIndex(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);;
	}
	
	public void deselectByIndex(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.deselectByIndex(index);
	}
	
	public void deselectByValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.deselectByValue(value);
	}
	
	public void deselectByVisibleText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.deselectByVisibleText(text);
	}
	
	public void isMultiple(WebElement ele) {
		Select sel = new Select(ele);
		sel.isMultiple();
	}
	
	public void executeScript(WebDriver driver,String key,WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(key, ele);
	}
	
	public void executeScriptargu(WebDriver driver,String key,WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	}
}
