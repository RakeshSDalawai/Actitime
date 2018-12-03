	package com.actitime.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.actitime.generic.BasePage;

	public class LoginPage extends BasePage
	{
		//Declaration
		@FindBy(id="username")
		private WebElement usernameTB;
		
		@FindBy(name="pwd")
		private WebElement passwordTB;
		
		@FindBy(xpath="//div[.='Login ']")
		private WebElement loginBTN;
		
		@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
		private WebElement version;
		
		@FindBy(xpath="//span[contains(.,'invalid')]")
		private WebElement errorMessage;
		
		//Initialization
		public LoginPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		
		public void verifyPage(String eTitle)
		{
			verifyTitle(eTitle);
		}
		
		public void enterUserName(String un)
		{
			usernameTB.sendKeys(un);
		}
		
		public void enterPassword(String pwd)
		{
			passwordTB.sendKeys(pwd);
		}
		
		public void clickOnLogin()
		{
			loginBTN.click();
		}
		
		public String verifyErrorMessage()
		{
			verifyElement(errorMessage);
			String aErrMessage = errorMessage.getText();
			return aErrMessage;
		}
		
		public String verifyVersion()
		{
			verifyElement(version);
			String aVersion = version.getText();
			return aVersion;
		}
	}
