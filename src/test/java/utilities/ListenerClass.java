package utilities;
import test.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;




public class ListenerClass extends BaseClass implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
	
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String testName = result.getName();
		
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/" + testName + "_" + timestamp + ".jpg");
	
		try {
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot saved: "+dest.getAbsolutePath());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}	

}
