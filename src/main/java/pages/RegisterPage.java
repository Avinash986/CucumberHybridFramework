package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy (id="input-password")
	private WebElement passwordfield;
	
	@FindBy (id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(name="agree")
	private WebElement privacypolicyoption;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continuebutton;
	
	@FindBy(name="newsletter")
	private WebElement newsletterrbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningmessage;
	
	@FindBy(xpath="\"//input[@name='firstname']/following-sibling::div\"")
	private WebElement alertdismiss;
	
	
	
	public void EnterFirstName(String firstnametext) {
		firstNameField.sendKeys(firstnametext);
	}
	public void EnterLastName(String lastnametext) {
		lastNameField.sendKeys("lastnametext");
	}
	
	public void EnterEmail(String emailtext) {
		emailfield.sendKeys(emailtext);
	}
	public void EnterTelephone(String telephonetext) {
		telephonefield.sendKeys(telephonetext);
	}
	public void EnterPassword(String passwordtext) {
		passwordfield.sendKeys(passwordtext);
	}
	public void EnterConfirmPassword(String passwordtext) {
		confirmpasswordfield.sendKeys(passwordtext);
	}
	public void selectPrivacyPolicy() {
		privacypolicyoption.click();
	}
	public void clickonContinueButton() {
		continuebutton.click();
	}
	public void clickonnewseleeter() {
		newsletterrbutton.click();
	}
	
	public String getWarningmessage() {
		return warningmessage.getText();
	}
	
	public String getalertdismiss() {
		return alertdismiss.getText();
	}

}
