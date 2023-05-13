package com.usga.qa.screens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.usga.qa.base.Driver;

public class VerifyScorecardData extends Driver
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
		@FindBy(xpath="")
		public WebElement favicon;
		
		@FindBy(id="")
		public WebElement roundselector;
		
		@FindBy(xpath="")
		public WebElement playerxpath;
		
		@FindBy(xpath="")
		public WebElement roundselectorxpath;
		
		@FindBy(xpath="")
		public WebElement scorecardback;
	   }
	   
		public void favsearchedplayer(String favplyer)
		
		{
			String toggle=verifyscorecarddata.favicon.getText();
			
			if(toggle.equalsIgnoreCase(favplyer))
			{
				System.out.println("player is favorited");
			}
			else {
				verifyscorecarddata.favicon.click();
				System.out.println("Plyer is fvorited");
			}
		}
		
		public void selectroundselector(String roundNo)
		{
			Select round=new Select(verifyscorecarddata.roundselector);
			round.selectByVisibleText(roundNo);
			
		}
		public void verifyData(String playername,  String RoundNo)
		{
			String player=verifyscorecarddata.playerxpath.getText();
			String round=verifyscorecarddata.roundselectorxpath.getText();
			
			
			if((player.equalsIgnoreCase(playername))&& (round.equalsIgnoreCase(RoundNo)))
				{
				System.out.println("Scorecard data is verified successfully");
				}
			else {
				System.out.println("Scorecard is not matched ");
			}
		}
		public void clickscorecardback()
		{
			verifyscorecarddata.scorecardback.click();
		}
		
}
