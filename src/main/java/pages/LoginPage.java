package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailAddressLocator;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordLocator;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	
//	By emailAddressLocator = By.xpath("//input[@data-qa='login-email']");
//	By passwordLocator = By.xpath("//input[@data-qa='login-password']");
//	By loginButton = By.xpath("//button[@data-qa='login-button']");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername(String emailAddress)
	{
		type(emailAddressLocator, emailAddress);	
	}
	
	public void enterPassword(String password)
	{
		type(passwordLocator, password);	
	}
	
	public void clickLoginButton()
	{
		click(loginButton);
	}
	
	public String getLoginTitle()
	{
		return driver.getTitle();
	}
	
	
	//All the locators of that page
	//Executions on those locators
	
}
