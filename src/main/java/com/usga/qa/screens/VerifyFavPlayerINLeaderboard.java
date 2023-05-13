package com.usga.qa.screens;


import com.usga.qa.base.Driver;

public class VerifyFavPlayerINLeaderboard extends Driver 
{
	
		public void searchFvoritedplayer(String playername) throws Exception
		
		{
			SearchPlayer player=new SearchPlayer();
			
			player.clicksearchIcon();
		    player.enableSearchField();
			player.enterPlayername(playername);
			
			
		}
		public void verifyFavToggleinLederbord(String favtoggle)
		{
			VerifyScorecardData verifyfavtoggle=new VerifyScorecardData();
			verifyfavtoggle.favsearchedplayer(favtoggle);
		}
	
}
