package com.usga.qa.androidscreens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.usga.qa.androidscreens.GetStartedScreen.pageObjects;
import com.usga.qa.base.androidDriver;

public class VerifyFavPlayerINLeaderboard extends androidDriver 
{
	//checkbox=(//android.widget.CheckBox)[1]
	
	pageObjects unfavoritesearchedplayer;

	   public VerifyFavPlayerINLeaderboard() 
		{
	        super();

	   unfavoritesearchedplayer = new pageObjects();

	  PageFactory.initElements(driver, unfavoritesearchedplayer);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="(//android.widget.CheckBox)[1]")
		public WebElement unfavorite;
	   }
			
		public void searchFvoritedplayer(String playername) throws Exception
		
		{
			SearchPlayer player=new SearchPlayer();
			
			player.clicksearchIcon();
		    player.enableSearchField();
			player.enterPlayername(playername);
			
			
		}
		public void verifyFavToggleinLederbord() throws Exception
		{
			unfavoritesearchedplayer.unfavorite.click();			
			System.out.println("Player is Unfavorited");
			
			

}
}