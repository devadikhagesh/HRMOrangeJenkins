package hrm.testscripts;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


import hrm.pages.LoginPage;
import hrm.utilities.Browser;
import hrm.utilities.ReadData;

public class TC001 {
	WebDriver driver;
	@BeforeClass(groups="smoke")
	public void browserSetup() {
	driver=Browser.openBrowser();
	Browser.openURL();
	}
	@AfterClass
	public void tearDown() {
		Browser.closeBrowser();
	}
	@Test(groups="smoke")
	public void verifyHRMLogin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		String uname=ReadData.getData("logindetails","username");
		String pass=ReadData.getData("logindetails","password");
		LoginPage login=new LoginPage(driver);
		login.hrmLogin(uname,pass);
		
		
	}
	

}
