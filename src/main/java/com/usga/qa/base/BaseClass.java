
package com.usga.qa.base;


import java.io.File;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class BaseClass
{
	 static Properties property;
	 protected static AndroidDriver driver=null;
	 protected static IOSDriver idriver=null;
	 private static String apppackage = propertiesclass.initializeproperties("appPackage");
	 private static String appactivity = propertiesclass.initializeproperties("appActivity");
	 private static String platformnameandroid = propertiesclass.initializeproperties("platformNameAndroid");
	 private static String platformnameios = propertiesclass.initializeproperties("platformNameIOS");
	 private static AppiumDriverLocalService  service;
	 
	
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
		 System.out.println(platformnameandroid);
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformnameandroid);
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
         desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
         desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973F/DS");
         //desiredCapabilities.setCapability(MobileCapabilityType.APP, "/path/to/ios/app.zip");
         desiredCapabilities.setCapability("appPackage", apppackage);
         System.out.println(apppackage);
         desiredCapabilities.setCapability("appActivity", appactivity);
         System.out.println(appactivity);
       
       /*  URL url = new URL("http://127.0.0.1:4723/wd/hub");
         System.out.println(url);
         driver = new AndroidDriver(url, desiredCapabilities);
         */
       
         
         startServer();
         System.out.println(service.getUrl());
         driver = new AndroidDriver(service.getUrl(), desiredCapabilities);
         
         
         System.out.println("Launch the USGA app in Android ");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));        
         }       
	      
	    
		else 
		{
       	 System.out.println("No device Found");
        }
	}	
	public static void iosinitialization() throws Exception
	{
		 if(platformnameios.equalsIgnoreCase("IOS"))
		{
			try {
			System.out.println(platformnameios);
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformnameios);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4.1");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/someghana/Downloads/USGA QA.ipa");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"00008101-000C14D6026B001E");
           // URL url = new URL("http://127.0.0.1:4723/wd/hub");
            System.out.println("launch the appium server");
           // System.out.println(url);
            startServer();
            idriver = new IOSDriver(service.getUrl(), desiredCapabilities);
            System.out.println("Launch the USGA app in IOS");
            idriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
        catch(Exception e)
        {
       	 e.printStackTrace();
        }	
		
  } 
		 else {
        	 System.out.println("No device Found");
         }
	}
	
	public static void startServer () 
	{
       		
		AppiumServiceBuilder builder = new AppiumServiceBuilder ();
        builder         
            .withAppiumJS (
                new File ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
            .usingDriverExecutable (new File ("/usr/local/bin/node"))
            .withIPAddress ("127.0.0.1")
            .usingPort (4723)  
            .withArgument (BASEPATH, "/wd/hub")
            .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument (GeneralServerFlag.LOG_LEVEL, "debug")
            .withLogFile(new File("Appiumlog.txt"));

        service = AppiumDriverLocalService.buildService (builder);
        service.start ();
		
    }
	public static void stopServer ()
	{
		service.stop();		
    }
	
}

