package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
       WebDriver driver;
       
       public LoginPage(WebDriver driver) {
    	   this.driver=driver;
    	   PageFactory.initElements(driver, this);
       }
       @FindBy(id="input-email")
       private WebElement emailfield;
       
       @FindBy(id="input-password")
       private WebElement passwordfield;
       
       @FindBy(xpath="//input[@type='submit']")
       private WebElement loginbutton;
       
       
       @FindBy(xpath="\"//div[@class='alert alert-danger alert-dismissible']\"")
       private WebElement warningmessage;
       
       public void enteremailaddress(String emailtext) {
    	   emailfield.sendKeys(emailtext);
       }
       public void enterpassword(String passwordtext) {
    	   passwordfield.sendKeys(passwordtext);
       }
       public void loginpageclick() {
    	   loginbutton.click();
       }
       public String getwarningmessagetext() {
    	  return warningmessage.getText();
       }
}
