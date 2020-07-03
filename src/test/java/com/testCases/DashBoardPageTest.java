package com.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pageObject.DashboardPage;
import com.pageObject.LoginPage;
import com.setup.BaseClass;

public class DashBoardPageTest extends BaseClass {
	WebDriver driver;
	public DashboardPage d1;
	
	
  @BeforeClass
  public void setUp() {
	  driver = getDriver();
  }
	
  @Test
  public void verifyLogin() {
	  LoginPage login = new LoginPage(driver);
	  d1 = login.SignIn("mngr267577", "bubaped");
	  d1.verifyLogin("Manger Id : mngr267577");
	  if(d1.verifyLogin("Manger Id : mngr267577")) {
		  System.out.println("User logged in Success");
	  }
	  else {
		  System.out.println("User logged out failed");
	  }
	  
  }
  
  @Test
  public void verifyLogout() {
	  Boolean loginPage = d1.verifyLogOut("UserID");
	  if(loginPage) {
		  System.out.println("User logged out Success");
	  }
	  else {
		  System.out.println("User logged out failed");
	  }
  }
}
