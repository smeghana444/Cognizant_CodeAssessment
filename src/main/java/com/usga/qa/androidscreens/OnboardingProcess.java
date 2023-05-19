package com.usga.qa.androidscreens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.androidDriver;


public class OnboardingProcess extends androidDriver
{
	pageObjects onboarding;

	   public OnboardingProcess() 
		{
	        super();

	        onboarding = new pageObjects();

	  PageFactory.initElements(driver, onboarding);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="//android.view.View[@content-desc=\"Select to provide permissions Button. Double tap to activate\"]")
		public WebElement selectpermissions;
		
		@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
		public WebElement Allowlocpopup;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Next Button on USGA Tutorial page Double tap to activate\"]")
		public WebElement championshipselectortutorial;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Next Button on USGA Tutorial page Double tap to activate\"]")
		public WebElement myticketstutorial;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Done Button Double tap to activate\"]")
		public WebElement donetutorial;
		
	   }
		public void selectPermissions() throws Exception		
		{
			onboarding.selectpermissions.click();
			Thread.sleep(1000);
		}
		
		public void allowLocPopup() throws Exception
		{
			onboarding.Allowlocpopup.click();
			Thread.sleep(1000);
		}
		
		public void championshipSelectorTutorial() throws Exception
		{
			
			onboarding.championshipselectortutorial.click();
			Thread.sleep(1000);
		}
		
		public void myTicketsTutorial() throws Exception
		{
			onboarding.myticketstutorial.click();
			Thread.sleep(1000);
		}
		
		public void doneTutorial() throws Exception
		{
			onboarding.donetutorial.click();
			Thread.sleep(1000);
		}
		
}
