package com.actitime.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
	public WebDriver driver;
	 
	@BeforeMethod
	public void precondition()
	{
	    System.setProperty("webdriver.gecko.driver","./Drivers/geckoDriver.exe");
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		driver.get("https://www.actitime.com/download");
	}
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}


	}
