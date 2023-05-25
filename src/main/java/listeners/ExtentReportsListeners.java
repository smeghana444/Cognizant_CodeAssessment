package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.usga.qa.base.BaseClass;
import com.usga.qa.base.ExtentManager;
import com.usga.qa.base.ExtentTestManager;
import com.usga.qa.base.androidDriver;
import com.usga.qa.base.iosDriver;

import io.appium.java_client.AppiumDriver;


public class ExtentReportsListeners extends BaseClass implements ITestListener
{	
	public ExtentReports extent;
    public ExtentTest test;
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
    
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
		
	}

		  public void onTestFailure(ITestResult result)
		  {
			  try {
			    System.out.println("*** Test " + result.getMethod().getMethodName() + " Failed...");
				ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
				ExtentTestManager.getTest().log(Status.FAIL,"Test Case is Failed "+result.getThrowable());	
				String testName=result.getName();
				System.out.println(" Test Name is "+testName);
				if(testName.contains("Android"))
				{
					AppiumDriver androiddriver=((AppiumDriver)driver);
					String screenshotpath=androidDriver.takescreenshot(testName, androiddriver);
					ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotpath);
					ExtentTestManager.getTest().log(Status.FAIL, "Screenshot Captured successfully");
					System.out.println("Screenshot saved successfully");
				} 
				
				if(testName.contains("IOS"))
				{
					AppiumDriver iosdriver=((AppiumDriver)idriver);
					String screenshotpath=iosDriver.takescreenshot(testName, iosdriver);
					ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotpath);
					ExtentTestManager.getTest().log(Status.FAIL, "Screenshot Captured successfully");
					System.out.println("Screenshot captured successfully");
				} }catch(Exception e)
			  {
					e.printStackTrace();
			  }
				
		  }
		  	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		ExtentTestManager.getTest().log(Status.SKIP,"Test Case is Skipped "+result.getThrowable());	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}