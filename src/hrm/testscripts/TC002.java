package hrm.testscripts;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import hrm.pages.AddEmpolyee;
import hrm.pages.LoginPage;
import hrm.utilities.Browser;
import hrm.utilities.ReadData;

public class TC002 {
	WebDriver driver;
	@BeforeClass(groups="smoke")
	public void browserSetup() {
	driver=Browser.openBrowser();
	Browser.openURL();
	}
	@AfterClass(groups="smoke")
	public void tearDown() {
		Browser.closeBrowser();
	}
	@Test(priority=1,groups="smoke")
	public void verifyHRMLogin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		String uname=ReadData.getData("logindetails","username");
		String pass=ReadData.getData("logindetails","password");
		LoginPage login=new LoginPage(driver);
		login.hrmLogin(uname,pass);
		
		
	}
	@Test(priority=2,dependsOnMethods="verifyHRMLogin",groups="sanity")
	public void verifyHRMAddEmplyee() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		AddEmpolyee add=new AddEmpolyee(driver);
		String fname=ReadData.getData("empdetails","firstname");
		String lname=ReadData.getData("empdetails","lastname");
		
		add.hrmAddEmpolyee(fname,lname);
		
	}

}
