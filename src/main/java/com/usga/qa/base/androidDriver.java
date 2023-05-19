package com.usga.qa.base;




import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class androidDriver extends BaseClass
{	
   
protected AndroidDriver driver;

public androidDriver()
{
	this.driver=super.getAndroiddriver();
	
}
public static String takescreenshot(String testName, AppiumDriver driver)
{
	if (screenshotsubfoldername == null) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        screenshotsubfoldername = myDateObj.format(myFormatObj);

    }
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destFile = new File("./Screenshots/"+screenshotsubfoldername+"/" +testName);
    try {
		FileUtils.copyFile(sourceFile, destFile);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Screenshot saved successfully");
	return destFile.getAbsolutePath();
}

}
