package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	
	@Parameters({"username", "password"})
	@Test
	public void performLogin(String username, String password)
	{
		WebDriver driverref = DriverManager.getDriver();
		LoginPage loginpage = new LoginPage(driverref);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		String pageTitle = loginpage.getLoginTitle();
		Assert.assertEquals(pageTitle, "Automation Exercise");
	}
}
