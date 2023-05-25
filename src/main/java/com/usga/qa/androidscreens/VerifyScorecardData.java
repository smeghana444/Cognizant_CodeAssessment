package com.usga.qa.androidscreens;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.androidDriver;

public class VerifyScorecardData extends androidDriver
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
		@FindBy(xpath="//android.widget.CheckBox[@content-desc=\"Favorite button\"]")
		public WebElement favicon;
		
		@FindBys(
		@FindBy(className="android.widget.TextView"))
		public List<WebElement> selecttab;
		
		@FindBy(className="android.widget.Button")
		public WebElement roundselector;
		
		@FindBys(
		@FindBy(xpath="//android.widget.ScrollView/android.view.View/android.widget.Button"))
		public List<WebElement> selectround;
		
		
		
		@FindBys(
		@FindBy(xpath="//android.view.View/android.widget.TextView"))
		public List<WebElement> verifyplayername_round;
						
				
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Back button\"]")
		public WebElement scorecardback;
		
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Back button: Cancel the search action and dismiss the search bar\"]")
		public WebElement exitsearchfield;
		
		
		
	   }
	   
		public void favsearchedplayer() throws Exception
		
		{
			Thread.sleep(2000);
			verifyscorecarddata.favicon.click();
        	Thread.sleep(1000);
        	System.out.println("Player is favorited");
						
		}
		
		public void selecttab() throws Exception
		{
			try {
   				
				List<WebElement> tabnames=verifyscorecarddata.selecttab;
	            int size=tabnames.size();
	            System.out.println(size);
	            for (int i = 0; i < size; i++) {
	                String gettab = tabnames.get(i).getText();
	                System.out.println(gettab);
	                
	                if (gettab.equalsIgnoreCase("Scorecard")) 
	                {
	                	tabnames.get(i).click();
	                	Thread.sleep(1000);
	                    break;
	                } 
	                
	                }
	      	}catch(Exception e)
				{
	      		e.printStackTrace();
				}
		}
		
		public void selectroundselector(String roundNo)throws Exception
		{
			verifyscorecarddata.roundselector.click();
			try {
				List<WebElement> rounds=verifyscorecarddata.selectround;
				Thread.sleep(2000);
	            int size=rounds.size();
	            int roundsize=Integer.parseInt(roundNo);
	            System.out.println("size " +size);
	            System.out.println("roundsize"+roundsize);
	            for (int i = 1; i<=size; i++)
	            {
	            	Thread.sleep(2000);
	            	System.out.println("size " +i);
	            	System.out.println("roundsize"+roundsize);
	                 if (i==roundsize)
	                {	 	                
	                   	Thread.sleep(3000);
	                	rounds.get(i-1).click();
	                	System.out.println("Player Found");
	                    break;
	                } 
	                
	            }
	      	}catch(Exception e)
				{
	      		e.printStackTrace();
				}
			}
			
			
		
		public void verifyData(String playername)throws Exception
		{
			try {
				List<WebElement> verifydata=verifyscorecarddata.verifyplayername_round;
	            int size=verifydata.size();
	            System.out.println(size);
	            for (int i = 0; i < size; i++) {
	                String getdata = verifydata.get(i).getText();
	                System.out.println(getdata);
	                Thread.sleep(2000);
	                if (getdata.equalsIgnoreCase(playername+" ")) 
	                {
	                	System.out.println("Player name is verified in scorecard");
	                	Thread.sleep(1000);
	                    break;
	                } 
	                
	                }
	      	}catch(Exception e)
				{
	      		e.printStackTrace();
				}
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
