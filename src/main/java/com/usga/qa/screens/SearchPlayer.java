package com.usga.qa.screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.Driver;

public class SearchPlayer extends Driver
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
		@FindBy(className="android.view.View"))
		public List<WebElement> verifyplayername;
		
	   }
		public void selectScoring()
		
		{
			try {
			selectscoring.selectscoringtab.click();
			Thread.sleep(1000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
        public void clicksearchIcon()
		
		{
        	try {
			selectscoring.searchicon.click();
			Thread.sleep(1000);
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
		}
       public void enableSearchField()
		
		{
        	try {
			selectscoring.enablesearchfield.click();
			Thread.sleep(3000);
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
	}	
		
       public void enterPlayername(String playerName) throws Exception
		
		{
    	   try {
			selectscoring.playername.click();
			Actions action = new Actions(driver);
		    action.sendKeys(playerName).perform();
			Thread.sleep(1000);
    	   }catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
		}
       public void verifyPlayerName(String verifydata) throws Exception
       {
    	   try {
    		   		   
    		   List<WebElement> verifyname=selectscoring.verifyplayername;
               int size=verifyname.size();
               System.out.println(size);
               for (int i = 0; i < size; i++) {
                   String verify = verifyname.get(i).getText();
                   System.out.println(verify);
                   if (verify.equalsIgnoreCase(verifydata)) 
                   {
                	System.out.println("Player Found");
                	verifyname.get(i).click();
                   	Thread.sleep(1000);
                     break;
                   } else
            	   {
            		   System.out.println("Player Not Found " +verifydata);
            	   }

               }
    	   
    	   
       }catch(Exception e)
    	   {
    	   e.printStackTrace();
    	   }
}
}
