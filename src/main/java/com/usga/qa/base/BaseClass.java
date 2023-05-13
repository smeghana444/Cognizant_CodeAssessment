package com.usga.qa.base;


import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass
{
	 static Properties property;
	 private static AppiumDriver driver=null;;
	 private static String apppackage = propertiesclass.initializeproperties("appPackage");
	 private static String appactivity = propertiesclass.initializeproperties("appActivity");
	 private static String platformname = propertiesclass.initializeproperties("platformName");
	
	 
	
	public AppiumDriver getdriver()
	{
		return driver;
	}
	
	public static void initialization() 
	{
		if(platformname.equalsIgnoreCase("Android"))
		{
			System.out.println("Android");
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
         desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
         desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973F");
         //desiredCapabilities.setCapability(MobileCapabilityType.APP, "/path/to/ios/app.zip");
         desiredCapabilities.setCapability("appPackage", apppackage);
         System.out.println(apppackage);
         desiredCapabilities.setCapability("appActivity", appactivity);
         System.out.println(appactivity);
         try {
         URL url = new URL("http://127.0.0.1:4723/wd/hub");
         System.out.println("install app");
         System.out.println(url);
         driver = new AppiumDriver(url, desiredCapabilities);
         System.out.println("Launch the app");
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         
	    }
		
		else if(platformname.equalsIgnoreCase("IOS"))
		{

	            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
	            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4.1");
	            //  desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
	            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
	            desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/someghana/Library/Developer/Xcode/DerivedData/WebDriverAgent-aghlrsejdreqngftgvcqwnjgrbou/Build/Products/Debug-iphoneos/IntegrationApp.app");
	           // desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
	            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"00008101-000C14D6026B001E");
	            try {
	            URL url = new URL("http://127.0.0.1:4723/wd/hub");
	            System.out.println("install app");
	            System.out.println(url);
	            driver = new AppiumDriver(url, desiredCapabilities);
	            System.out.println("Launch the app");
	            }catch(Exception e)
	            {
	            	e.printStackTrace();
	            }
    }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
  } 
}

