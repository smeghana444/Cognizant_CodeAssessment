package com.usga.qa.iosscreens;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.iosDriver;
import com.usga.qa.base.propertiesclass;
import io.appium.java_client.ios.IOSDriver;




public class SelectChampionship extends iosDriver
{
	pageObjects championshipselector;

	   public SelectChampionship() 
		{
	        super();

	        championshipselector = new pageObjects();

	  PageFactory.initElements(idriver, championshipselector);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="//XCUIElementTypeButton[@name=\"Championship selector\"]/XCUIElementTypeImage[1]")
		public WebElement selectchampionshipdropdown;
		
		@FindBy(xpath="//XCUIElementTypeTextField[@name=\"Search input field\"]")
		public WebElement enterchampionship;
				
		
		@FindBy(xpath="//XCUIElementTypeAny[@name=\"USGA QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther")
		public WebElement selectchampionship;
		
	   }
		public void selectChampionshipDropdown() throws Exception
		
		{
			championshipselector.selectchampionshipdropdown.click();
			Thread.sleep(1000);
		}
		public void enterchampionship(String selectChampionship) throws Exception
		
		{
		championshipselector.enterchampionship.click();
		Thread.sleep(1000);			
		Actions action = new Actions(idriver);
	    action.sendKeys(selectChampionship).perform();
		Thread.sleep(3000);
		String platformname=propertiesclass.initializeproperties("platformNameIOS");
		if(platformname.equalsIgnoreCase("IOS"))
		{	//AndroidDriver driver1=((AndroidDriver)driver);
			((IOSDriver)idriver).hideKeyboard();
		System.out.println("Keyboard hide in IOS app");
		Thread.sleep(2000);
		}
		else
		{
			System.out.println("Keyboard is not hidden");
		}
		
		}
		public void selectChampionship(String selectChampionship) throws Exception
		{	
			championshipselector.selectchampionship.click();
			Thread.sleep(1000);
                
		}
}
        

