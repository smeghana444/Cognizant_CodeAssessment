package com.usga.qa.iosscreens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.iosDriver;
import com.usga.qa.base.propertiesclass;
import io.appium.java_client.ios.IOSDriver;

public class SearchPlayer extends iosDriver
{
	pageObjects selectscoring;

	   public SearchPlayer() 
		{
	        super();
	        selectscoring = new pageObjects();

	  PageFactory.initElements(idriver, selectscoring);
	   }
	   class pageObjects
	   {
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Latest scores and leaderboard\"]")
		public WebElement selectscoringtab;
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
		public WebElement searchicon;
		
	
		@FindBy(xpath="//XCUIElementTypeTextField[@name=\"Search input field\"]")
		public WebElement playername;
		
		
		@FindBy(xpath="//XCUIElementTypeApplication[@name=\"USGA QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]")
		public WebElement verifyplayername;
				
				
		
	   }
		public void selectScoring()throws Exception
		{
			selectscoring.selectscoringtab.click();
			Thread.sleep(1000);
			
		}
        public void clicksearchIcon()throws Exception
		
		{
        	selectscoring.searchicon.click();
			Thread.sleep(1000);
        	
		}    
		
       public void enterPlayername(String playerName)throws Exception
		
		{   	
			selectscoring.playername.click();
			Actions action = new Actions(idriver);
		    action.sendKeys(playerName).perform();
			Thread.sleep(3000);		
			String platformname=propertiesclass.initializeproperties("platformNameIOS");
			if(platformname.equalsIgnoreCase("IOS"))
			{	
				((IOSDriver)idriver).hideKeyboard();
			System.out.println("Keyboard hide in IOS app");
			Thread.sleep(2000);
			}
			else
			{
				System.out.println("Keyboard is not hidden");
			}
    	}
       
       public void verifyPlayerName(String verifydata)throws Exception
       {
    	 
    	   selectscoring.verifyplayername.click();
		   Thread.sleep(1000);  		   
    		      	   
       } 
}
