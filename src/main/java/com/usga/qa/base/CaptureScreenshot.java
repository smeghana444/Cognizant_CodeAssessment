package com.usga.qa.base;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshot extends Driver
{
public  static String screenshotsubfoldername;

public void capturescreenshot(String fileName) throws  Exception
{
    if (screenshotsubfoldername == null) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
         screenshotsubfoldername = myDateObj.format(myFormatObj);

    }
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("./Screenshots/"+screenshotsubfoldername+"/" +fileName);
    FileUtils.copyFile(sourceFile, destFile);
    System.out.println("Screenshot saved successfully");
}
}