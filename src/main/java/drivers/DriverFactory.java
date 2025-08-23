package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	
	public static WebDriver createDriver(String browser)
	{
		WebDriver driver = null;
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser name is not supported: " + browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}

	
}

