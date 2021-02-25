package hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import hrm.utilities.Browser;
import hrm.utilities.Log;

public class LoginPage {
	private WebDriver driver;
	
	private By username=By.xpath("//*[@id=\"txtUsername\"]");
	private By password=By.xpath("//*[@id=\"txtPassword\"]");
	private By login=By.xpath("//*[@id=\"btnLogin\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	private void setUserName(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	private void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);	
	}
	private void clickOnLogin() {
		driver.findElement(login).click();	
	}
	public void hrmLogin(String uname,String pass) {
		this.setUserName(uname);
		this.setPassword(pass);
		this.clickOnLogin();
		Browser.verifyHRMLogin("dashboard");
		Reporter.log("Verified HRMLogin");
		Log.info("Verified HRMLogin");
	}

}
