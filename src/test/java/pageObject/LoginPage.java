package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String uEmail) {
		
		userEmail.sendKeys(uEmail);
	
	}
    public void setPassword(String uPwd) {
		
    	userPassword.sendKeys(uPwd);
	
	}
    public void btn_Login() {
		
	 btnLogin.click();
	
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
	}


