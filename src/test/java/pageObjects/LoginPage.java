package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	

   @FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
   @FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
   @FindBy(xpath="//button[normalize-space()='Login']") WebElement btnlogin;
   
   public void SetEmail(String email)
   {
	   txtemail.sendKeys(email);
   }
   public void SetPassword(String pwd)
   {
	   txtpassword.sendKeys(pwd);
   }
   public void Clicklogin()
   {
	   btnlogin.click();
   }

}
