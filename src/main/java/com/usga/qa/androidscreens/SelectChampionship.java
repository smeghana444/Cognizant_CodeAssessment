package com.usga.qa.androidscreens;



import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.androidDriver;
import com.usga.qa.base.propertiesclass;

import io.appium.java_client.android.AndroidDriver;




public class SelectChampionship extends androidDriver
{
	pageObjects championshipselector;

	   public SelectChampionship() 
		{
	        super();

	        championshipselector = new pageObjects();

	  PageFactory.initElements(driver, championshipselector);

	   }
	   class pageObjects
	   {
		@FindBy(xpath="//android.view.View[@content-desc=\"Championships Selector button: Select the desired championship to view its corresponding content\"]")
		public WebElement selectchampionshipdropdown;
		
		@FindBy(xpath="//android.view.View[@content-desc=\"Search championship input field: Enter the championship name to search\"]")
		public WebElement enterchampionship;
		
		
		@FindBys(
		@FindBy(xpath="//android.view.View//android.widget.TextView")) 
		public List<WebElement> elements;
		
	   }
		public void selectChampionshipDropdown() throws Exception
		
		{
			championshipselector.selectchampionshipdropdown.click();
			Thread.sleep(1000);
		}
		public void enterchampionship(String selectChampionship) throws Exception
		
		{
		championshipselector.enterchampionship.click();	
		Thread.sleep(2000);
		Actions action = new Actions(driver);
	    action.sendKeys(selectChampionship).perform();
		Thread.sleep(3000);
		String platformname=propertiesclass.initializeproperties("platformNameAndroid");
		if(platformname.equalsIgnoreCase("Android"))
		{
		((AndroidDriver)driver).hideKeyboard();
		System.out.println("Keyboard hide in android app");
		Thread.sleep(2000); 
		}
		else
		{
			System.out.println("Keyboard is not hidden");
		}
		}
		public void selectChampionship(String selectChampionship) throws Exception
		{	
			try {
				Thread.sleep(2000); 				
			List<WebElement> championshipnames=championshipselector.elements;
            int size=championshipnames.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                String getchampionship = championshipnames.get(i).getText();
                System.out.println(getchampionship);
                
                if (getchampionship.equalsIgnoreCase(selectChampionship)) 
                {
                	championshipnames.get(i).click();
                	Thread.sleep(5000);
                    break;
                } 
                
             }
      	}catch(Exception e)
			{
      		e.printStackTrace();
			}
		}
}
        

