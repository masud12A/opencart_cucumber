package stepDefination;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import utilities.DataReader;

public class Steps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountpage macc;
	
	Logger logger;
	ResourceBundle rb;
	String br;
	
	@Before
	public void setup()
	{
		 logger=LogManager.getLogger(this.getClass());
		 rb=ResourceBundle.getBundle("Config");
		 br=rb.getString("browser");
		
	}
	@After
	public void teardown(Scenario scenario)
	{
		 System.out.println("scenario status==>"+scenario.getStatus());
		 if(scenario.isFailed())
		 {
			 byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenshot, "img/png", scenario.getName());
		 }
		 
		 driver.quit();
	}
	
	@Given("User launch browser")
	public void user_launch_browser() {
		
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("Opens URL {string}")
	public void opens_url(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	    
	}

	@When("User navigates to MyAccount menu")
	public void user_navigates_to_my_account_menu() {
		
		hp=new HomePage(driver);
		hp.ClickMyaccount();
		logger.info("Clicked on MyAccount menu..");
	     
	}

	@When("Click on Login")
	public void click_on_login() {
	    
		hp=new HomePage(driver);
		hp.Clicklogin();
		logger.info("Clicked on login..");
	}
	

	@When("User enters email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	    
		lp=new LoginPage(driver);
		lp.SetEmail(email);
		logger.info("Provided email..");
		lp.SetPassword(pwd);
		logger.info("Provided password....");
		
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	     
		lp=new LoginPage(driver);
		lp.Clicklogin();
		logger.info("Clicked on login button...");
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
	     
		macc=new MyAccountpage(driver);
		boolean targetpage=macc.isMyAccountpageExists();
		
		if(targetpage)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	
	
	@Then("Check User navigates to MyAccountpage by passing email and password with excel row {string}")
	public void check_user_navigates_to_my_accountpage_by_passing_email_and_password_with_excel_row(String rows) {
	     
		List<HashMap<String, String>> datamap=DataReader.data(System.getProperty("user.dir")+"\\testdata\\logindata.xlsx","sheet1");
		
		int index=Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		lp=new LoginPage(driver);
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		
		lp.Clicklogin();
		
		
		macc=new MyAccountpage(driver);
		boolean targetpage=macc.isMyAccountpageExists();
		
		if(exp_res.equals("valid"))
		{
			if(targetpage==true)
			{
				macc.Clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp_res.equals("invalid"))
		{
			if(targetpage==true)
			{
				macc.Clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}





}
