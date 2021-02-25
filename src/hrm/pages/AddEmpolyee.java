package hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import hrm.utilities.Browser;
import hrm.utilities.Log;



public class AddEmpolyee {

	private WebDriver driver;
	private WebDriverWait wait;
	private By pim=By.linkText("PIM");
	private By addEmp=By.linkText("Add Employee");
	private By firstname=By.id("firstName");
	private By lastname=By.id("lastName");
	private By savebtn=By.id("btnSave");
	
	public AddEmpolyee(WebDriver driver) {
		this.driver=driver;
	}
	
		
	
	private void mousehover() {
		Actions action=new Actions(driver);
		WebElement pimtab=driver.findElement(pim);
		action.moveToElement(pimtab).build().perform();
	}
	private void clickOnAddEmp() {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmp));
		driver.findElement(addEmp).click();
	}
	private void setFirstName(String fname){
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
		driver.findElement(firstname).sendKeys(fname);
		
	}
	private void setLastName(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}
	private void clickOnSave() {
		driver.findElement(savebtn).click();
	}
	public void hrmAddEmpolyee(String fname,String lname) {
		this.mousehover();
		this.clickOnAddEmp();
		this.setFirstName(fname);
		this.setLastName(lname);
		this.clickOnSave();
		Browser.verifyHRMLogin("empNumber");
		Reporter.log("Add HRM Empolyee Functionality Verified");
		Log.info("Add HRM Empolyee Functionality Verified");
	}

}
