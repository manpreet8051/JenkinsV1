package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DashboardPage {
	
	private WebDriver driver; 
	
	By logOutButton = By.xpath("//li/a[text()='Log out']");
	By myDashLink = By.xpath("//div//h2[text()='Guru99 Bank']");
	By welComeMessage = By.xpath("//td[text()='Manger Id : mngr267577']");
	By userIdLabel = By.xpath("//td[text()='UserID']");
	

	
	public DashboardPage(WebDriver driver2) {
		driver = driver2;
	}
	
	public boolean verifyLogin(String expectedMessage) {
		String actualMessage = driver.findElement(welComeMessage).getText();
		return actualMessage.equals(expectedMessage);
		
	}
	
	public boolean verifyLogOut(String expectedDetail) {
		driver.findElement(logOutButton).click();
		driver.switchTo().alert().accept();
		String actualMessage = driver.findElement(userIdLabel).getText();
		
		SoftAssert asserty = new SoftAssert();
		asserty.assertEquals(expectedDetail, actualMessage);
		if(actualMessage.equalsIgnoreCase(expectedDetail)) {
			return true;
		}
		else {
			return false;
		}
	}

}
