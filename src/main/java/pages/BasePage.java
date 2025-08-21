package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	public WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void click(WebElement locator)
	{
		locator.click();
//		driver.findElement(locator).click();
	}
	
	public void type(WebElement locator, String text)
	{
		locator.clear();
		locator.sendKeys(text);
//		WebElement element = driver.findElement(locator);
//		element.clear();
//		element.sendKeys(text);
	}
	
	public String getText(WebElement locator)
	{
		return locator.getText();
	}	
	
}
