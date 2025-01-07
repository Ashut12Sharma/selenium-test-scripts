package CustomerportalTest.customerPortaltest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import customerPortal.resources.ExtentReporterNg;

//Lisners class
public class Listeners extends emailmethods implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNg.getReportObject();
	
	//Remove concerruncy issue
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		//to get the remort method name
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //create unique thread id
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		//Take screenshot
		extentTest.get().fail(result.getThrowable());//if fail
		//test.log(Status.FAIL, "Test is failed");
		//get driver
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//taking screenshot
		String filePath=null;
		try {
			filePath = getScrrenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		//attach to the report
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();
	}
	
}
