package stepdefinations;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class register {
	WebDriver driver;
	HomePage hm;
	RegisterPage rp;
	AccountSuccessPage acp;
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	   driver=DriverFactory.getDriver();
	   hm=new HomePage(driver);
	   hm.clickonMyAccount();
	   //driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   //driver.findElement(By.linkText("Register")).click();
	   hm.clickonRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		rp=new RegisterPage(driver);
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		rp.EnterFirstName(dataMap.get("firstname"));
		rp.EnterLastName(dataMap.get("lastName"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
		rp.EnterEmail(CommonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		rp.EnterTelephone(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		rp.EnterPassword(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		rp.EnterConfirmPassword(dataMap.get("password"));
		
		
	}
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		//driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		rp.EnterFirstName(dataMap.get("firstname"));
		rp.EnterLastName(dataMap.get("lastName"));
		rp.EnterEmail(dataMap.get("email"));
		rp.EnterTelephone(dataMap.get("telephone"));
		rp.EnterPassword(dataMap.get("password"));
		rp.EnterConfirmPassword(dataMap.get("password"));
		
		
	}

	@And("User select Private Policy")
	public void user_select_private_policy() {
		//driver.findElement(By.name("agree")).click();
		//rp=new RegisterPage(driver);
		rp.selectPrivacyPolicy();
		
	}

	@And("User clicks on Continue Button")
	public void user_clicks_on_continue_button() {
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//rp=new RegisterPage(driver);
		rp.clickonContinueButton();
	}

	@Then("User account should get create sucessfully")
	public void user_account_should_get_create_sucessfully() {
	   //Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
		acp=new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!",acp.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	  // driver.findElement(By.name("newsletter")).click();
		rp.clickonnewseleeter();
	}

	@Then("User account should get proper warning about duplicate email")
	public void user_account_should_get_proper_warning_about_duplicate_email() {
		//Assert.assertTrue(rp.getWarningmessage().contains("Warning: E-Mail Address is already registered!"));
		Assert.assertTrue(rp.getWarningmessage().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	private boolean getWarningmessage() {
		// TODO Auto-generated method stub
		return false;
	}

	@When("User not enter any details into field")
	public void user_not_enter_any_details_into_field() {
	   rp=new RegisterPage(driver);
	   
	}


	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
	   Assert.assertEquals("First Name must be between 1 and 32 characters!",rp.getalertdismiss());
	}
	/*
	 * private String getEmailWithTimeStamp() { Date date=new Date(); return
	 * "avinash"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com"; }
	 */

}
