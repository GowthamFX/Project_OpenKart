package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage {
	
	
public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		
	}



@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;
@FindBy(xpath="//input[@name='agree']")
WebElement chkAgree;
@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgconfirm;


public void setFirstName(String fname) {
	
	txtFirstname.sendKeys(fname);
}

public void setLastName(String lname) {
	
	txtLastname.sendKeys(lname);
}

public void setEmail(String email) {
	
	txtEmail.sendKeys(email);
}

public void setTelephone(String teleph) {
	
	txtTelephone.sendKeys(teleph);
}

public void setPassword(String pwd) {
	
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String cnfpwd) {
	
	txtConfirmPassword.sendKeys(cnfpwd);
}
public void setPrivacyPolicy() {
	
	chkAgree.click();
}

public void clickContinue() {
	
	btnContinue.click();
	
	//sol2
    //btnContinue.submit();
	//sol3
	//Actions a =  new Actions(driver);
	//a.moveToElement(btnContinue).click().perform();
	//sol4
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",btnContinue);
	//sol5
	//btnContinue.sendKeys(Keys.RETURN);
	//sol6
//	WebDriverWait myweb = new WebDriverWait(driver, Duration.ofSeconds(10));
//	myweb.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	
	
}

public String getConfirmationMessage() {
	
	try {
		
		return(msgconfirm.getText());
		
	} catch (Exception e) {
		return (e.getMessage());
	}
	
}
		
}













