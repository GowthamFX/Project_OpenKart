package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void Verify_Login() {
		
		
		logger.info("******* Started TC002_LoginTest ***** ");
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginr();
		
		//LoginPage
		LoginPage lo= new LoginPage(driver);
		lo.setEmail(p.getProperty("email"));
		lo.setPassword(p.getProperty("password"));
		lo.btn_Login();
		
		
		
		//MyAccount
		MyAccountPage myac = new MyAccountPage(driver);
		boolean targetPage = myac.isMyAccountPageExists();
		
	    //Assert.assertEquals(targetPage, true,"Login failed");
		Assert.assertTrue(targetPage);
	   }
	   catch (Exception e) 
		{
		   Assert.fail();
		}
		
		logger.info("******* Finished TC002_LoginTest ***** ");
			
		}
	
		
		
		
		
		
		
		

	

}
