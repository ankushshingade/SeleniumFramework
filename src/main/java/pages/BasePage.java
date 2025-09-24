package pages;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//BasePage class: Contains common Selenium actions that can be reused across all pages

public class BasePage {
	
	public WebDriver driver;                 // WebDriver instance for browser interactions
	public JavascriptExecutor js;            // For JavaScript execution (scrolling, etc.)

	 // Constructor: Initialize WebDriver and JavaScript executor	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

	 // Scrolls a WebElement into view using JavaScript
	 public void scrollIntoView(WebElement element) 
	 {
	     js.executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	
	 // Clicks on an element located by By locator	
	 public void click(By clickLoc) 
	 {
	     driver.findElement(clickLoc).click();
	 }
	
	 // Types text into an input field after clearing it	
	 public void type(By textLoc, String text) 
	 {
	     driver.findElement(textLoc).clear();
	     driver.findElement(textLoc).sendKeys(text);
	 }
	
	 // Selects a value from a dropdown by visible text
	 public void selectDropDown(By selectLoc, String day) 
	 {
	     Select select = new Select(driver.findElement(selectLoc));
	     select.selectByVisibleText(day);
	 }
	
	 // Returns a single WebElement
	 public WebElement findElement(By locator) {
	     return driver.findElement(locator);
	 }
	
	 // Returns a list of WebElements
	 public List<WebElement> findElements(By locator) 
	 {
	     return driver.findElements(locator);
	 }
	
	 // Gets the value of an attribute 
	 public String getAttribute(By locator) 
	 {
	     return findElement(locator).getAttribute("value");
	 }
	
	 // Switches to browser alert
	 public Alert switchToAlert() 
	 {
	     return driver.switchTo().alert();
	 }
	
	 // Accepts the alert
	 public void acceptAlert() 
	 {
	     switchToAlert().accept();
	 }
	
	 // Dismisses the alert
	 public void dismissAlert() 
	 {
	     switchToAlert().dismiss();
	 }
	
	 // Returns alert text
	 public String getAlertText() 
	 {
	     return switchToAlert().getText();
	 }
	
	 // Gets the current page URL
	 public String getCurrentUrl() 
	 {
	     return driver.getCurrentUrl();
	 }
	
	 // Gets the page title
	 public String pageTitle() 
	 {
	     return driver.getTitle();
	 }
	
	 // Gets the visible text of an element
	 public String getPageText(By locator) 
	 {
	     return driver.findElement(locator).getText();
	 }
	
	 // Checks if an element is visible on the page
	 public boolean isElementVisible(By locator) 
	 {
	     try 
	     {
	         return findElement(locator).isDisplayed();
	     } catch (Exception e) {
	         return false; // Element not found or not visible
	     }
	 }	
	
}
