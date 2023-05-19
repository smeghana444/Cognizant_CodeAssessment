package com.usga.qa.androidscreens;

import com.usga.qa.base.androidDriver;

public class VerifyFavPlayerINLeaderboard extends androidDriver 
{
	//checkbox=(//android.widget.CheckBox)[1]
			
		public void searchFvoritedplayer(String playername) throws Exception
		
		{
			SearchPlayer player=new SearchPlayer();
			
			player.clicksearchIcon();
		    player.enableSearchField();
			player.enterPlayername(playername);
			
			
		}
		public void verifyFavToggleinLederbord(String favtoggle) throws Exception
		{
			VerifyScorecardData verifyfavtoggle=new VerifyScorecardData();
			verifyfavtoggle.favsearchedplayer(favtoggle);
/*String toggle=verifyscorecarddata.favicon.getText();
			
			if(toggle.equalsIgnoreCase(favplyer))
			{
				System.out.println("player is favorited");
			}
			else {
				verifyscorecarddata.favicon.click();
				System.out.println("Plyer is fvorited");
			}
		}*/
	
}
}