package com.usga.qa.screens;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.usga.qa.base.Driver;


public class SelectChampionship extends Driver
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
		
		@FindBys(
		@FindBy(xpath="//android.view.View//android.widget.TextView")) 
		public List<WebElement> elements;
		
	   }
		public void selectChampionshipDropdown() throws Exception
		
		{
			championshipselector.selectchampionshipdropdown.click();
			Thread.sleep(1000);
		}
		public void selectChampionship(String selectChampionship) throws Exception
		{		
			List<WebElement> championshipnames=championshipselector.elements;
            int size=championshipnames.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                String getchampionship = championshipnames.get(i).getText();
                System.out.println(getchampionship);
                if (getchampionship.equalsIgnoreCase(selectChampionship)) 
                {
                	championshipnames.get(i).click();
                	Thread.sleep(1000);
                    break;
                }

            }
		}
        
}
