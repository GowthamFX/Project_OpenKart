package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "DataDriven")
	public void verify_LoginDDT(String email, String pwd, String exp) {

		logger.info("******* Started TC003_LoginDDT ***** ");
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginr();

		// LoginPage
		LoginPage lo = new LoginPage(driver);
		lo.setEmail(email);
		lo.setPassword(pwd);
		lo.btn_Login();

		// MyAccount
		MyAccountPage myac = new MyAccountPage(driver);
		boolean targetPage = myac.isMyAccountPageExists();

		if (exp.equalsIgnoreCase("Valid")) {

			if (targetPage == true) 
			{
				myac.ClickLogout();
				Assert.assertTrue(true);

			} 
			else 
			{
				Assert.assertTrue(false);
			}}

			if (exp.equalsIgnoreCase("Invalid")) {

				if (targetPage ==true) 
				{
					myac.ClickLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					Assert.assertTrue(true);
				}
			}
		}
	
			   catch (Exception e) 
				{
				   Assert.fail();
				}
				
				logger.info("******* Finished TC003_LoginDDT ***** ");
					
		
	}}

	
		

	

