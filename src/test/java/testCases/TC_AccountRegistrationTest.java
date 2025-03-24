package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC_AccountRegistrationTest extends BaseClass {
	
   
	
	@Test(groups = {"Regression","Master"})
	public void verify_AccountRegistration() throws InterruptedException {
		
		logger.info("***** Starting TC_AccountRegistrationTest *********");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link ........");
		hp.clickRegister();
		logger.info("Clicked on Register link .......");
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer detail .....");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randommail
		regpage.setTelephone(randomeNumeric());
		
		String password = randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		
		String cofMesg = regpage.getConfirmationMessage();
		Assert.assertEquals(cofMesg, "Your Account Has Been Created!");
		
		}
		catch (Exception e) {
			
			logger.error("Test Failed....");
			//logger.debug("Debug Logs....");
			Assert.fail();
		}
		
		logger.info("Logs are Finished..... ");


	}}
