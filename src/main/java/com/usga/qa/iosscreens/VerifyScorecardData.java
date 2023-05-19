package com.usga.qa.iosscreens;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.iosDriver;

public class VerifyScorecardData extends iosDriver
{
	pageObjects verifyscorecarddata;

	   public VerifyScorecardData() 
		{
	        super();

	        verifyscorecarddata = new pageObjects();

	  PageFactory.initElements(driver, verifyscorecarddata);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Favorite player Unchecked\"]")
		public WebElement favicon;
		
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Back\"]")
		public WebElement scorecardback;
		
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Exit\"]")
		public WebElement exitsearchfield;
		
		
		
	   }
	   
		public void favsearchedplayer(String favplyer) throws Exception
		
		{
			verifyscorecarddata.favicon.click();
        	Thread.sleep(1000);
        	System.out.println("Player is favorited");
			
			
		}
				
		public void clickscorecardback()throws Exception
		{
			verifyscorecarddata.scorecardback.click();
			Thread.sleep(1000);
		}
		public void exitsearchfield()throws Exception
		{
			verifyscorecarddata.exitsearchfield.click();
			Thread.sleep(1000);
		}
		
}
