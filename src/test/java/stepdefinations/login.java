package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class login {
	WebDriver driver;
	LoginPage lp;
	AccountPage ac;
	HomePage hm;
	
	@Given("User navigate to login page")
	public void User_navigate_to_login_page() {
		hm=new HomePage(driver);
		driver=DriverFactory.getDriver();
		hm.clickonMyAccount();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
		//hm.clickonLogin();
	}
	@When("^User has enter valid email address (.+) into email field")
	public void User_has_enter_valid_email_address_into_email_field(String emailtext){
		 lp=new LoginPage(driver);
		//driver.findElement(By.id("input-email")).sendKeys(emailtext);
		lp.enteremailaddress(emailtext);
	}
	@And("^User has enter valid password (.+) into password field")
	public void user_has_enter_valid_password_into_password_field(String passwordtext) {
	  // driver.findElement(By.id("input-password")).sendKeys(password);
		lp.enterpassword(passwordtext);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	   //driver.findElement(By.xpath("//input[@type='submit']")).click();
		lp.loginpageclick();
	}

	@Then("User should get logged in")
	public void user_should_get_logged_in() {
		ac=new AccountPage(driver);
		Assert.assertTrue(ac.dispalyAccountInfo());
	   
	}

	@When("User enter invalid email address into email field")
	public void user_enter_invalid_email_address_into_email_field() {
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
		 lp = new LoginPage(driver);
		lp.enteremailaddress(CommonUtils.getEmailWithTimeStamp());
	}

	@And("User enter invalid password {string} into password field")
	public void user_enter_invalid_password_into_password_field(String invalidpassword) {
		//driver.findElement(By.id("input-password")).sendKeys(invalidpassword);
		 lp = new LoginPage(driver);
		 lp.enterpassword(invalidpassword);
	}

	@Then("User should get proper warning message")
	public void user_should_get_proper_warning_message() {
	   Assert.assertTrue(lp.getwarningmessagetext().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	

	@When("User not enter email address into email field")
	public void user_not_enter_email_address_into_email_field() {
		//driver.findElement(By.id("input-email")).sendKeys();
		lp=new LoginPage(driver);
		lp.enteremailaddress("");
		
	}

	@When("User not enter password into password field")
	public void user_not_enter_password_into_password_field() {
		//driver.findElement(By.id("input-password")).sendKeys();
		lp=new LoginPage(driver);
		lp.enterpassword("");
	}
	




}
