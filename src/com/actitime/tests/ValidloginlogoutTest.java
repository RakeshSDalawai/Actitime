package com.actitime.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidloginlogoutTest extends BaseTest
{
	@Test
	public void testValidLoginLogout() throws InterruptedException
	{
		String user = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 0);
		String pass = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 1);
		String loginTitle=ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 2);
		String EnterTimeTrackTitle = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 3);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		//verify the login page
		lp.verifyPage("actiTIME - Login");//(loginTitle);
	
		//enter valid username
		Reporter.log("valid username: "+user,true);
		lp.enterUserName("admin");//(user);
		
		//enter valid password
		Reporter.log("Valid password: "+pass,true);
		lp.enterPassword("manager");//(pass);
		
		//click on login
		lp.clickOnLogin();
		
		//verify the enter time track page
		lp.verifyPage("actiTIME - Enter Time-Track");//(EnterTimeTrackTitle);
		
		//click on logout
		Thread.sleep(2000);
		ep.clickOnLogout();
		
		//verify the login page
		lp.verifyPage("actiTIME - Login");//(loginTitle);
	}
}
