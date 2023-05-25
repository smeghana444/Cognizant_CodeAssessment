package com.usga.qa.base;


import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass
{
	 static Properties property;
	 protected static AndroidDriver driver=null;
	 protected static IOSDriver idriver=null;
	 private static String apppackage = propertiesclass.initializeproperties("appPackage");
	 private static String appactivity = propertiesclass.initializeproperties("appActivity");
	 private static String platformnameandroid = propertiesclass.initializeproperties("platformNameAndroid");
	 private static String platformnameios = propertiesclass.initializeproperties("platformNameIOS");
	 public  static String screenshotsubfoldername;
	 
	
	public AndroidDriver getAndroiddriver()
	{
		return (AndroidDriver) driver;
	}
	public IOSDriver getIOSdriver()
	{
		return (IOSDriver) idriver;
	}	
	
	public static void androidinitialization() throws Exception
	{
		if(platformnameandroid.equalsIgnoreCase("Android"))
		{
		 System.out.println("Android");
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformnameandroid);
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
         driver = new AndroidDriver(url, desiredCapabilities);
         System.out.println("Launch the app");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         
	    }
	}	
	public static void iosinitialization() throws Exception
	{
		 if(platformnameios.equalsIgnoreCase("IOS"))
		{
			try {
			System.out.println("IOS");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformnameios);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4.1");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/someghana/Downloads/USGA QA.ipa");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"00008101-000C14D6026B001E");
           URL url = new URL("http://127.0.0.1:4723/wd/hub");
            System.out.println("install app");
            System.out.println(url);
            idriver = new IOSDriver(url, desiredCapabilities);
            System.out.println("Launch the app");
            idriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
        
    
		
		
		
  } 
	}
	
	
	
}

