package com.usga.qa.tests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.usga.qa.base.BaseClass;
import com.usga.qa.base.ReadDataFromExcel;
import com.usga.qa.screens.SelectChampionship;
import com.usga.qa.screens.VerifyFavPlayerINLeaderboard;
import com.usga.qa.screens.VerifyScorecardData;
import com.usga.qa.screens.GetStartedScreen;
import com.usga.qa.screens.OnboardingProcess;
import com.usga.qa.screens.SearchPlayer;

public class PlayerSearch extends ReadDataFromExcel
{
public String repName;
public ExtentHtmlReporter sparkReporter;
public ExtentReports extent;

	@BeforeClass
	public void setup()
	{
		BaseClass.initialization();
	}


	@Test(priority=1)
	public void testGetStartedButton() throws Exception
	{
	GetStartedScreen getstartedbutton=new GetStartedScreen();
	getstartedbutton.clickgetstartedbutton();
	}

	@Test(priority=2)
	public void selectPermissionsButton() throws Exception
	{
		OnboardingProcess permissions=new OnboardingProcess();
		permissions.selectPermissions();
		permissions.allowLocPopup();
		permissions.championshipSelectorTutorial();
		permissions.myTicketsTutorial();
		permissions.doneTutorial();
	}
	@Test(priority=3,dataProvider = "getTestData")
	public void selectChampionship(String championshipname, String playername,String FavIcon, String RoundNo) throws Exception
	{
		SelectChampionship selectchampionship=new SelectChampionship();
		selectchampionship.selectChampionshipDropdown();
		selectchampionship.selectChampionship(championshipname);
		
	}
	@Test(priority=4,dataProvider="getTestData")
	public void enterPlayerName(String championshipname, String playername,String FavIcon, String RoundNo) throws Exception
	{
		SearchPlayer enterplayer=new SearchPlayer();
		enterplayer.selectScoring();
		enterplayer.clicksearchIcon();
		enterplayer.enableSearchField();
		System.out.println(playername);
		enterplayer.enterPlayername(playername);
		enterplayer.verifyPlayerName(playername);
	}
	@Test(priority=5, dataProvider="getTestData")
	public void FavPlayer_and_VerifyScorecardData(String championshipname, String playername,String FavIcon, String RoundNo)
	{
		VerifyScorecardData verify=new VerifyScorecardData();
		verify.favsearchedplayer(FavIcon);
		verify.selectroundselector(RoundNo);
		verify.verifyData(playername, RoundNo);
		verify.clickscorecardback();
	}
	@Test(priority=6, dataProvider="getTestData")
	public void verify_favplayer_in_leaderboard(String championshipname, String playername,String FavIcon, String RoundNo) throws Exception
	{
		VerifyFavPlayerINLeaderboard verifytoggle= new VerifyFavPlayerINLeaderboard();
		verifytoggle.searchFvoritedplayer(playername);
		verifytoggle.verifyFavToggleinLederbord(FavIcon);
	}
}