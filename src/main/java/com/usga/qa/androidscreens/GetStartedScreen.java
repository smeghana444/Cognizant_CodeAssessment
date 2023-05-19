package com.usga.qa.androidscreens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.usga.qa.base.androidDriver;


public class GetStartedScreen extends androidDriver
{
	pageObjects getstarted;

   public GetStartedScreen() 
	{
        super();

    getstarted = new pageObjects();

  PageFactory.initElements(driver, getstarted);

   }
   class pageObjects
   {
	@FindBy(xpath="//android.view.View[@content-desc=\"Get Started with the USGA App Button. Double tap to activate\"]")
	public WebElement getstartedbutton;
   }
	public void clickgetstartedbutton() throws Exception
	
	{
		Thread.sleep(5000);
		getstarted.getstartedbutton.click();
		Thread.sleep(3000);
	}
	

	
}
