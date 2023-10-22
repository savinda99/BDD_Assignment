package com.actitime.qa.pages;

import functions.PageFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class HomePage extends TestBase {
	
	Logger log = Logger.getLogger(HomePage.class);
	PageFunctions pageFunctions = new PageFunctions();
	//Page Factory - Object Repository
	
		@FindBy(xpath = "//a[@class='content tasks']")
		WebElement taskLink;
		
		@FindBy(xpath = "//a[@class='content reports']")
		WebElement reportsLink;
		
		@FindBy(xpath = "//div[@id='logo_aT']")
		WebElement actitimeLogo;

		private By usersLink = By.xpath( "//a[@class='content users']");
		
	
		
		//initialization
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
			
			
		}
		
		
		//Action/Methods
		
		public Boolean validateActiTimeLogo() {
			
			
			log.info("Validated Logo");
			return actitimeLogo.isDisplayed();
			
			
		}
		
		
		
		public TasksPage clickOnTaskLink() {
			
			taskLink.click();
			return new TasksPage();
			
		}
		
		
        public ReportsPage clickOnReportsLink() {
        	
        	log.info("Validated Logo");
			
	         reportsLink.click();
	         return new ReportsPage();
			
		}

		public UsersPage clickOnUsersLink() throws InterruptedException {
			pageFunctions.waitAndClickOnElement(usersLink);
			return  new UsersPage();
		}
	
}
