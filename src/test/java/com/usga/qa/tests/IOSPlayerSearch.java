package com.usga.qa.tests;

import org.testng.annotations.Test;
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
	}

	@Test(priority=1)
	public void testGetStartedButton_IOS() throws Exception
	{
	GetStartedScreen getstartedbutton=new GetStartedScreen();
	getstartedbutton.clickgetstartedbutton();
	ExtentTestManager.getTest().log(Status.INFO, "Clicked on Get Started Button");
	}

	@Test(priority=2)
	public void selectPermissionsButton_IOS() throws Exception
	{
		OnboardingProcess permissions=new OnboardingProcess();
		permissions.selectPermissions();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Select Permissions Button");
		permissions.allowNotiPopup();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on allow Notification popup");
		permissions.allowLocPopup();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Allow Location popup");
		permissions.championshipSelectorTutorial();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on Championship Selectorial Tutorial");
		permissions.myTicketsTutorial();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked Next on MyTickets Tutorial");
		permissions.doneTutorial();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Done Tutorial");
	}
	@Test(priority=3,dataProvider = "getTestData")
	public void selectChampionship_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		SelectChampionship selectchampionship=new SelectChampionship();
		selectchampionship.selectChampionshipDropdown();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Championship Selector dropdown");
		selectchampionship.enterchampionship(championshipname);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on championship selector searchfield");
		selectchampionship.selectChampionship(championshipname);
		ExtentTestManager.getTest().log(Status.INFO, "Selected "+championshipname+ "championship");
		
	}
	@Test(priority=4,dataProvider="getTestData")
	public void enterPlayerName_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		SearchPlayer enterplayer=new SearchPlayer();
		enterplayer.selectScoring();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Select Scoring Menu");
		enterplayer.clicksearchIcon();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search Icon");
		enterplayer.enterPlayername(playername);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Playername "+playername);
		enterplayer.verifyPlayerName(playername);
		
	}
	
	@Test(priority=5, dataProvider="getTestData")
	public void FavPlayer_and_VerifyScorecardData_IOS(String championshipname, String playername,String RoundNo) throws Exception
	{
		VerifyScorecardData verify=new VerifyScorecardData();
		verify.favsearchedplayer(playername);
		verify.clickscorecardback();
		verify.exitsearchfield();
	}
	
}
