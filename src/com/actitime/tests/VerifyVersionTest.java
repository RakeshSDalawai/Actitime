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

	public class VerifyVersionTest extends BaseTest
	{
		@Test(priority=3)
		public void testVerifyVersion()
		{
			String loginTitle = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 2);
			String expectedVersion = ExcelData.getData("./data/Book1.xlsx", "Sheet1", 1, 0);
			
			LoginPage lp = new LoginPage(driver);
			
			//verify the login page
			lp.verifyPage(loginTitle);
			
			//verify version
			String actualVersion = lp.verifyVersion();
		
			Reporter.log("Actual Version: "+actualVersion,true);
			Reporter.log("Expected Version: "+expectedVersion,true);
			
			AssertJUnit.assertEquals(actualVersion, expectedVersion);
			Reporter.log("Version is matching.............",true);
		}
	}