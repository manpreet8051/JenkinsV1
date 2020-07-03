package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;

public class LoginPage {
	
	private WebDriver driver; 
	
	By userId = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//input[@name='btnLogin']");
	
	public LoginPage(WebDriver driver1) {
		driver = driver1;
	}
	
	public DashboardPage SignIn(String username,String pass) {
		DashboardPage d1 = null;
		driver.findElement(userId).sendKeys(username);
	
		driver.findElement(password).sendKeys(pass);
	
		driver.findElement(loginButton).click();
				
		d1 = new DashboardPage(driver);
		new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(d1.logOutButton));
		return d1;
		
	}

}
