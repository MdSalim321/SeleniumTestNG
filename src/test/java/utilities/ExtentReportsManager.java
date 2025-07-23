package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsManager {
	
	public static ExtentReports extent;
	public static ExtentTest test; 
	
	public static ExtentReports getReportInstances()
	{
		if(extent == null)
		{
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
				String reportPath = System.getProperty("user.dir")+"/reports/extentsReports_"+"timeStamp"+".html";
				
				ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
				
				reporter.config().setDocumentTitle("Automation Test Report");
				reporter.config().setReportName("Test Execution Report");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				
		}
		
		return extent;
	}
	
	
	public static ExtentTest createTest(String testName)
	{
		test = getReportInstances().createTest(testName);
		return test;
	}
	
	public static String captureScreenShot(WebDriver driver, String screenShotName)
	
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("yyyy_MM_ddHHmmss").format(new Date());
		
		String path = System.getProperty("user.dir")+ "/Screenshots/"+screenShotName+"_"+timestamp+".jpg";
		
	//	File dest = new File(System.getProperty("user.dir")+"/Screenshots/" + screenShotName + "_" + timestamp + ".jpg");
		
		try {
		FileUtils.copyFile(src, new File(path));
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return screenShotName;
		
	}
	
	
	

}
