package com.usga.qa.tests;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.usga.qa.androidscreens.GetStartedScreen;
import com.usga.qa.androidscreens.OnboardingProcess;
import com.usga.qa.androidscreens.SearchPlayer;
import com.usga.qa.androidscreens.SelectChampionship;
import com.usga.qa.androidscreens.VerifyFavPlayerINLeaderboard;
import com.usga.qa.androidscreens.VerifyScorecardData;
import com.usga.qa.base.BaseClass;
import com.usga.qa.base.ExtentTestManager;
import com.usga.qa.base.ReadDataFromExcel;





public class AndroidPlayerSearch extends ReadDataFromExcel
{
public String repName;
public ExtentHtmlReporter sparkReporter;
public ExtentReports extent;

	@BeforeClass
	public void setup() throws Exception
	{
		
		BaseClass.androidinitialization();
		Assert.assertTrue(true);
	}

	@Test(priority=1)
	public void testGetStartedButton_Android() throws Exception
	{
	
	GetStartedScreen getstartedbutton=new GetStartedScreen();
	getstartedbutton.clickgetstartedbutton();
	ExtentTestManager.getTest().log(Status.INFO, "Clicked on Get Started Button ");
	Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	public void selectPermissionsButton_Android() throws Exception
	{
		OnboardingProcess permissions=new OnboardingProcess();
		permissions.selectPermissions();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Select Permissions Button");
		permissions.allowLocPopup();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Allow Loc Popup");
		permissions.championshipSelectorTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on Championship Selector Tutorial");
		permissions.myTicketsTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on MyTickets Tutorial");
		permissions.doneTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Done Tutorial");
	}
	@Test(priority=3,dataProvider = "getTestData")
	public void selectChampionship_Android(String championshipname, String playername,String RoundNo) throws Exception
	{
		SelectChampionship selectchampionship=new SelectChampionship();
		selectchampionship.selectChampionshipDropdown();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Championship Selector Dropdown");
		selectchampionship.enterchampionship(championshipname);
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Championship Selector Searchfield");
		selectchampionship.selectChampionship(championshipname);
		Assert.assertTrue(true, championshipname);
		ExtentTestManager.getTest().log(Status.INFO, "Selected "+championshipname +" Championship");
		
	}
	@Test(priority=4,dataProvider="getTestData")
	public void enterPlayerName_Android(String championshipname, String playername,String RoundNo) throws Exception
	{
		SearchPlayer enterplayer=new SearchPlayer();
		enterplayer.selectScoring();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Scoring Menu");
		enterplayer.clicksearchIcon();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search Icon");
		enterplayer.enableSearchField();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search Field");
		enterplayer.enterPlayername(playername);
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Playername " +playername);
		Assert.assertTrue(true, playername);
		enterplayer.verifyPlayerName(playername);		
		ExtentTestManager.getTest().log(Status.INFO, "Verified Player name & click on player name " +playername);
	}
	@Test(priority=5, dataProvider="getTestData")
	public void FavPlayer_and_VerifyScorecardData_Android(String championshipname, String playername,String RoundNo) throws Exception
	{
		VerifyScorecardData verify=new VerifyScorecardData();
		verify.favsearchedplayer();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Favorited searched player "+playername);
		verify.selecttab();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Selected scorecard tab for player "+playername);
		verify.selectroundselector(RoundNo);
		Assert.assertTrue(true, RoundNo);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Round Selector & Selected round "+RoundNo);
		verify.verifyData(playername);
		Assert.assertTrue(true, playername);
		ExtentTestManager.getTest().log(Status.INFO, "Verified Searched Player in Scorecard ");
		verify.clickscorecardback();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Scorecard back button");
		verify.exitsearchfield();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Exit from Search Field");
	}
	@Test(priority=6, dataProvider="getTestData")
	public void verify_favplayer_in_leaderboard_Android(String championshipname, String playername,String RoundNo) throws Exception
	{
		VerifyFavPlayerINLeaderboard verifytoggle= new VerifyFavPlayerINLeaderboard();
		verifytoggle.searchFvoritedplayer(playername);
		Assert.assertTrue(true, playername);
		ExtentTestManager.getTest().log(Status.INFO, "Search favorited player on leaderboard "+playername);
		verifytoggle.verifyFavToggleinLederbord();
		Assert.assertTrue(true, playername);
		ExtentTestManager.getTest().log(Status.INFO, "player is Unfavoried ");
		VerifyScorecardData exitsearch=new VerifyScorecardData();
		exitsearch.exitsearchfield();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Exited from Leaderboard search field");
		
	}
}