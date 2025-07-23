package test;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utilities.ExtentReportsManager;
import utilities.Log;

public class BaseClass {
	
	public WebDriver driver;
	public static ExtentReports event;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUpReport()
	{
		event = ExtentReportsManager.getReportInstances();
	}
	
	@AfterSuite
	public void tearDownReport()
	{
		event.flush();
	}
	
	@BeforeMethod
	public void setup()
	{
		Log.info("Starting WebDriver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("Opening the URL...");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	/*
	public void verifyTitle()
	{
		//driver.get("https://www.google.com/");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String actualTitle =driver.getTitle();
		String expectedTitle = "Google";
		System.out.println("actual title is: "+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, " Title does not matched");
	}
	*/
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
		// we have to make the screenshot name  dynamic 	
		String screenShotName = result.getInstanceName();	
			
		String screenShotPath=ExtentReportsManager.captureScreenShot(driver, screenShotName);
		test.fail("Test failed , ScreenShot added", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
		}
		
		Log.info("Closing browser...");
		driver.quit();
	}

}
