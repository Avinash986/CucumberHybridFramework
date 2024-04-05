package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
private WebDriver driver;

public ElementUtils(WebDriver driver) {
	this.driver=driver;
}
	
	public void clickonElement(WebElement element,long durationInSeconds) {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		//WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webelement=waitforElement(element,durationInSeconds);
		webelement.click();
	}
	
	public void typetextintoElement(WebElement element,String texttobeTyped, long durationInSeconds) {
		WebElement webelement=waitforElement(element,durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(texttobeTyped);
}
	public WebElement waitforElement(WebElement element ,long durationInSeconds) {
		WebElement webelement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webelement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return webelement;
		
	}
	public void selectoptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		WebElement webelement=waitforElement(element,durationInSeconds);
		Select select=new Select(webelement);
		select.selectByVisibleText(dropDownOption);
		
	}
	public void acceptAlert(long durationInSeconds) {
		Alert alert=waitforAlert(durationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds) {
		Alert alert=waitforAlert(durationInSeconds);
		alert.dismiss();
	}
	
	
	public Alert waitforAlert(long durationInSeconds) {
		Alert alert=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		WebElement webElement =waitForVisiblityOfElement(element, durationInSeconds);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisiblityOfElement(WebElement element ,long durationInSeconds) {
		WebElement webelemnt=null;
		WebElement webelement = null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webelement=wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
}

