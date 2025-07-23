package test;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;

import pages.LoginPage;
import utilities.ExtentReportsManager;
import utilities.Log;

public class LoginTest extends BaseClass{
	
	@Test
	public void testValidLogin() throws InterruptedException
	{
		Log.info("Starting login test");
		test = ExtentReportsManager.createTest("Login Test");
		
		LoginPage objPage = new LoginPage(driver);
		
		test.info("Entered username");
		objPage.enterUserName("Admin");
		Thread.sleep(4000);
		test.info("Entered password");
		objPage.enterPassword("admin123");
		Thread.sleep(4000);
		test.info("Click on the Login button");
		objPage.clickLogin();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not matched");
		test.info("Login successfull...");
		Thread.sleep(3000);
		test.info("Print All Links");
		objPage.getAllLinks();
		
		
	
	}

}
