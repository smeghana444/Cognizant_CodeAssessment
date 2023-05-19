package com.usga.qa.androidscreens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.usga.qa.base.androidDriver;
import com.usga.qa.base.propertiesclass;

import io.appium.java_client.android.AndroidDriver;

public class SearchPlayer extends androidDriver
{
	pageObjects selectscoring;

	   public SearchPlayer() 
		{
	        super();
	        selectscoring = new pageObjects();

	  PageFactory.initElements(driver, selectscoring);
	   }
	   class pageObjects
	   {
		@FindBy(xpath="//android.view.View[@content-desc=\"Latest scores and leaderboard Tab\"]")
		public WebElement selectscoringtab;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Search for a specific player\"]")
		public WebElement searchicon;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Search bar input field: Enter the first or the last name of the player you want to search\"]")
		public WebElement enablesearchfield;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Search bar input field: Enter the first or the last name of the player you want to search\"]/android.view.View")
		public WebElement playername;
		
		@FindBys(
		@FindBy(className="android.widget.TextView"))
		public List<WebElement> verifyplayername;
				
						
	   }
		public void selectScoring()throws Exception
		{
			Thread.sleep(1000);
			selectscoring.selectscoringtab.click();
			Thread.sleep(1000);
			
		}
        public void clicksearchIcon()throws Exception
		
		{
        	Thread.sleep(1000);
        	selectscoring.searchicon.click();
			
        	
		}
       public void enableSearchField()throws Exception
		
		{
    	   Thread.sleep(3000);
			selectscoring.enablesearchfield.click();
			
        	
	}	
		
       public void enterPlayername(String playerName)throws Exception
		
		{   	
			selectscoring.playername.click();
			Actions action = new Actions(driver);
		    action.sendKeys(playerName).perform();	
			String platformname=propertiesclass.initializeproperties("platformNameAndroid");
			Thread.sleep(3000);
			if(platformname.equalsIgnoreCase("Android"))
			{				
			((AndroidDriver)driver).hideKeyboard();
			System.out.println("Keyboard hide in Android app");		
			Thread.sleep(3000);
			}
			else
			{
				System.out.println("Keyboard is not hidden");
			}
    	   }
       public void verifyPlayerName(String verifydata)throws Exception
       {
    	 
    		   		   
    		   List<WebElement> verifyname=selectscoring.verifyplayername;
    		  
               int size=verifyname.size();
               System.out.println(size);
               for (int i = 0; i < size; i++) 
               {
                   String verify = verifyname.get(i).getText();
                   System.out.println(verify);
                   System.out.println(verifydata);
                   Thread.sleep(1000);
                   if (verify.equals(verifydata+" ")) 
                   {
                	System.out.println("Player Found");
                	verifyname.get(i).click();
                	System.out.println(verifydata+" Scorecard is opened");
                   	Thread.sleep(3000);
                     break;
                   } else
            	   {
            		   System.out.println("No players meet the criteria selected" +verifydata);
            		  
            	   }

               }
    	   
    	   } 
}
