package com.usga.qa.iosscreens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.iosDriver;

public class GetStartedScreen extends iosDriver
{
	pageObjects getstarted;

   public GetStartedScreen() 
	{
        super();

    getstarted = new pageObjects();

  PageFactory.initElements(idriver, getstarted);

   }
   class pageObjects
   {
	@FindBy(xpath="//XCUIElementTypeButton[@name=\"Get Started\"]")
	public WebElement getstartedbutton;
   }
	public void clickgetstartedbutton() throws Exception
	
	{
		Thread.sleep(5000);
		getstarted.getstartedbutton.click();
		Thread.sleep(1000);
	}
	

	
}
