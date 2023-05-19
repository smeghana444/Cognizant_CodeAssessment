package com.usga.qa.iosscreens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.iosDriver;


public class OnboardingProcess extends iosDriver
{
	pageObjects onboarding;

	   public OnboardingProcess() 
		{
	        super();

	        onboarding = new pageObjects();

	  PageFactory.initElements(idriver, onboarding);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Select to provide permissions\"]")
		public WebElement selectpermissions;
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Allow\"]")
		public WebElement Allownotipopup;
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Allow While Using App\"]")
		public WebElement Allowlocpopup;
		
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Next\"]")
		public WebElement championshipselectortutorial;
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Next\"]")
		public WebElement myticketstutorial;
		
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
		public WebElement donetutorial;
		
	   }
		public void selectPermissions() throws Exception		
		{
			onboarding.selectpermissions.click();
			Thread.sleep(1000);
		}
		
		public void allowNotiPopup() throws Exception
		{
			onboarding.Allownotipopup.click();
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
