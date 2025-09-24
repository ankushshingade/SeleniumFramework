package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.ConfigReader;

/*
 * Creates and initializes a WebDriver instance for the given browser.
 * Supported browsers: Chrome, Firefox, Edge.
 *
 ** The driver will be:
 * 
 *   1.Launched for the given browser
 *   2.Maximized to full screen
 *   3. Configured with a default implicit wait of 20 seconds
 * 
 *
 * @param browser The browser name
 * @return A fully initialized WebDriver
 * @throws IllegalArgumentException if the browser is not supported
 * 
 */

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.get("implicitWait"))));
		
		return driver;
		
	}

	
}

