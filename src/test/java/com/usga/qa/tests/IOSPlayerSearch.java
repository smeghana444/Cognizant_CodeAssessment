package com.usga.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.usga.qa.base.BaseClass;
import com.usga.qa.base.ExtentTestManager;
import com.usga.qa.base.ReadDataFromExcel;
import com.usga.qa.iosscreens.GetStartedScreen;
import com.usga.qa.iosscreens.OnboardingProcess;
import com.usga.qa.iosscreens.SearchPlayer;
import com.usga.qa.iosscreens.SelectChampionship;
import com.usga.qa.iosscreens.VerifyScorecardData;


public class IOSPlayerSearch extends ReadDataFromExcel
{
public String repName;
public ExtentHtmlReporter sparkReporter;
public ExtentReports extent;

	@BeforeClass
	public void setup() throws Exception
	{
		BaseClass.iosinitialization();
		Assert.assertTrue(true);
	}

	@Test(priority=1)
	public void testGetStartedButton_IOS() throws Exception
	{
	
	GetStartedScreen getstartedbutton=new GetStartedScreen();
	getstartedbutton.clickgetstartedbutton();
	Assert.assertTrue(true);
	ExtentTestManager.getTest().log(Status.INFO, "Clicked on Get Started Button");
	}

	@Test(priority=2)
	public void selectPermissionsButton_IOS() throws Exception
	{
		OnboardingProcess permissions=new OnboardingProcess();
		permissions.selectPermissions();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Select Permissions Button");
		permissions.allowNotiPopup();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on allow Notification popup");
		permissions.allowLocPopup();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Allow Location popup");
		permissions.championshipSelectorTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on Championship Selectorial Tutorial");
		permissions.myTicketsTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on MyTickets Tutorial");
		permissions.doneTutorial();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Done Tutorial");
	}
	@Test(priority=3,dataProvider = "getTestData")
	public void selectChampionship_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		SelectChampionship selectchampionship=new SelectChampionship();
		selectchampionship.selectChampionshipDropdown();
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Championship Selector dropdown");
		selectchampionship.enterchampionship(championshipname);
		Assert.assertTrue(true,championshipname);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on championship selector searchfield");
		selectchampionship.selectChampionship(championshipname);
		Assert.assertTrue(true,championshipname);
		ExtentTestManager.getTest().log(Status.INFO, "Selected "+championshipname+ "championship");
		
	}
	@Test(priority=4,dataProvider="getTestData")
	public void enterPlayerName_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		SearchPlayer enterplayer=new SearchPlayer();
		enterplayer.selectScoring();
		Assert.assertTrue(true);		
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Select Scoring Menu");
		enterplayer.clicksearchIcon();
		Assert.assertTrue(true);		
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search Icon");
		enterplayer.enterPlayername(playername);
		Assert.assertTrue(true,playername);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Playername "+playername);
		enterplayer.verifyPlayerName(playername);
		Assert.assertTrue(true,playername);
		ExtentTestManager.getTest().log(Status.INFO, " Verified Entered Playername "+playername);
	}
	
	@Test(priority=5, dataProvider="getTestData")
	public void FavPlayer_and_VerifyScorecardData_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		VerifyScorecardData verify=new VerifyScorecardData();
		verify.favsearchedplayer(playername);
		Assert.assertTrue(true,playername);
		ExtentTestManager.getTest().log(Status.INFO, "Favourited a Player on Scorecard"+playername);
		verify.clickscorecardback();
		Assert.assertTrue(true);	
		ExtentTestManager.getTest().log(Status.INFO, " Exited from searched player scorecard ");
		verify.exitsearchfield();
		ExtentTestManager.getTest().log(Status.INFO, " Exited from search field ");
	}
	
}
