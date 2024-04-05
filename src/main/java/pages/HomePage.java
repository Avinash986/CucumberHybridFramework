package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	WebDriver driver; 
	private ElementUtils elementUtils;
	public HomePage(WebDriver  driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchfield;
	
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchbutton;
	
	public void clickonMyAccount() {
		//myAccountDropMenu.click();
		//elementUtils.clickonElement(clickonMyAccount(), 0);
	}
	public void clickonLogin() {
		loginOption.click();
	}
	public void clickonRegister() {
		registerOption.click();
	}
	public void enterproductintoseqrchbox(String prodtext) {
		searchfield.sendKeys(prodtext);
	}
	public void clickonsearchbutton() {
		searchbutton.click();
	}
	
}
