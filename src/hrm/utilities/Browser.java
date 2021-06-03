package hrm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Browser {
	private static WebDriver driver;
	
	public static WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		driver=new ChromeDriver();
		return driver;
	}
	public static void openURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void verifyHRMLogin(String ExpectedUrl) {
		String actualUrl=driver.getCurrentUrl();
		boolean status=actualUrl.contains(ExpectedUrl);
		Assert.assertEquals(status, true,"Expected Url did not match with actualUrl");
		
	}

}
