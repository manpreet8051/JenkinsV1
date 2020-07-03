package com.setup;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseClass {
	ExtentReports reports;
	ExtentTest test;
	public WebDriver driver;
	
  
  public WebDriver getDriver() {
	  return driver;
  }
  
  public void initilaize(String browser ,String url) {
	  String basePath  = System.getProperty("user.dir");
	  switch(browser) {
	  case "IE":
		  System.setProperty("webdriver.ie.driver",basePath+"\\src\\test\\java\\drivers\\"+"IEDriverServer.exe" );
		  driver = new InternetExplorerDriver();
		  driver.manage().window().maximize();
		  driver.get(url);
		  Reporter.log("IE Browser is launched");
		  break;
	  case "FF":
		  System.out.println("FF Browser not available ,Try with another browser");
		  break;
	  case "Chrome":
		  System.setProperty("webdriver.chrome.driver",basePath+"\\src\\test\\java\\drivers\\"+"chromedriver.exe" );
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(url);
		  Reporter.log("Chrome Browser is launched");

		  break;
	  }
	  
  }
  
  @BeforeClass
  @Parameters({"browserName","url"})
  public void setup(String browser,String urlToOpen) {
	  initilaize(browser,urlToOpen);
	  
  }
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
  
  @BeforeMethod
  public void setUp() {
	  driver.quit();
  }
}
