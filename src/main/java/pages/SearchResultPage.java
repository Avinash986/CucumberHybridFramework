package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
WebDriver driver;
public SearchResultPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText="HP LP3065")
private WebElement validhpelement;

@FindBy (xpath="//input[@id='button-search']/following-sibling::p")
private WebElement messagetext;


public boolean dispalysatausofvalidprod() {
	return validhpelement.isDisplayed();
}
public String getmessageText() {
	return messagetext.getText();
}
}