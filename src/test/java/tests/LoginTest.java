package tests;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest extends BaseTest{
	
	@Parameters({"username", "password"})
	@Test
	public void performLogin(String username, String password)
	{
		System.out.println(username + " " + password);
		WebDriver driverref = DriverManager.getDriver();
		LoginPage loginpage = new LoginPage(driverref);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		String pageTitle = loginpage.getLoginTitle();
		Assert.assertEquals(pageTitle, "Automation Exercise");
	}
	
	@DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user1", "pass123"},
            {"Admin@gmail.com", "Admin@123"}
      };
    }
 
	@Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password );
        
        LoginPage loginpage = new LoginPage(DriverManager.getDriver());
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		String pageTitle = loginpage.getLoginTitle();
		Assert.assertEquals(pageTitle, "Automation Exercise");
    }
	
	 
	 @DataProvider(name = "loginDataExcel")
		public Object[][] loginData() {
		 
		    List<Map<String, String>> data = ExcelUtil.getData("src/test/resources/testdata/LoginData.xlsx", "Login");
		    Object[][] result = new Object[data.size()][1];
		    for (int i = 0; i < data.size(); i++) {
		        result[i][0] = data.get(i);
		    }
		    return result;
		}


		@Test(dataProvider = "loginDataExcel")
	    public void testLoginExcel(Map<String, String> testData) {
	        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	        
	        String username = testData.get("username");
	        String password = testData.get("password");
	        
	        System.out.println(username + " " + password);
	        
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLoginButton();

	        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.titleIs("Automation Exercise"));
	        String pageTitle = loginPage.getLoginTitle();
	       
		    Assert.assertEquals(pageTitle, "Automation Exercise");
//	        Assert.fail("This test case is intentionally failed.");
	    }
	 
}
