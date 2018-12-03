package com.actitime.tests;

	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.Test;

	import com.actitime.generic.BaseTest;
	import com.actitime.generic.ExcelData;
	import com.actitime.pages.LoginPage;

	public class InvalidLoginTest extends BaseTest
	{
		@Test(priority=2)
		public void testInvalidLogin() throws InterruptedException
		{
			String loginTitle = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 2);
			String expectedErrorMessage = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 2);
			
			LoginPage lp = new LoginPage(driver);
			
			//verify the login page
			lp.verifyPage(loginTitle);
			
			int rc = ExcelData.getRowCount("./data/Book1.xlsx", "TC02");
		
			for(int i=1;i<=rc;i++)
			{
				String user = ExcelData.getData("./data/Book1.xlsx", "Sheet2", 1, 0);
				String pass = ExcelData.getData("./data/Book1.xlsx", "Sheet2", 1, 1);
				
				//enter invalid username
				Reporter.log("Invalid username: "+user,true);
				lp.enterUserName(user);
				
				//enter invalid password
				Reporter.log("Invalid password: "+pass,true);
				lp.enterPassword(pass);
			
				//click on login
				lp.clickOnLogin();
				
				//verify error message
				String actualErrorMessage = lp.verifyErrorMessage();
				
				Reporter.log("Actual Error message: "+actualErrorMessage,true);
				Reporter.log("Expected Error message: "+expectedErrorMessage,true);			
				
				AssertJUnit.assertEquals(actualErrorMessage, expectedErrorMessage);
				Reporter.log("Error message is matching.............",true);
				
				Thread.sleep(1000);
				Reporter.log("======================================================",true);
			}
			

		}
	}