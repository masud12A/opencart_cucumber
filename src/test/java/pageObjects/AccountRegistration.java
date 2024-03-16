package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{
	 
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtlastname;
    @FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
    @FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
    @FindBy(xpath="//input[@name='agree']") WebElement chkpolicy;
    @FindBy(xpath="//button[normalize-space()='Continue']") WebElement btncontinue;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgconfirmation;
    
    public void SetFirstname(String fname)
    {
    	txtfirstname.sendKeys(fname);
    }
    public void SetLastname(String lname)
    {
    	txtlastname.sendKeys(lname);
    }
    public void Setemail(String email)
    {
    	txtemail.sendKeys(email);
    }
    public void Setpassword(String pwd)
    {
    	txtpassword.sendKeys(pwd);
    }
    public void Setprivacypolicy()
    {
    	chkpolicy.click();
    }
    public void Clickcontinue()
    {
    	btncontinue.click();
    }
    public String getConfirmationmsg()
    {
    	try
    	{
    	return(msgconfirmation.getText());
    	}
    	catch(Exception e)
    	{
    		return(e.getMessage());
    	}
    }

}
