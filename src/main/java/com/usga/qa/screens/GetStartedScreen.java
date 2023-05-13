package com.usga.qa.screens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.Driver;

public class GetStartedScreen extends Driver
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
		getstarted.getstartedbutton.click();
		Thread.sleep(1000);
	}
	

	
}
