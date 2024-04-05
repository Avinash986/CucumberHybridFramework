package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class search {
	WebDriver driver;
	HomePage hm;
	SearchResultPage srp;

@Given("User open the application")
public void user_open_the_application() {
    driver=DriverFactory.getDriver();
}

@When("User enters valid product {string} into search box field")
public void user_enters_valid_product_into_search_box_field(String validproducttext) {
   //driver.findElement(By.name("search")).sendKeys(validproducttext);
	hm=new HomePage(driver);
	hm.enterproductintoseqrchbox(validproducttext);
	
}

@When("User clicks on search button")
public void user_clicks_on_search_button() {
    //driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
	hm.clickonsearchbutton();
}

@Then("User should get display valid product in search result")
public void user_should_get_display_valid_product_in_search_result() {
   // Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	srp=new SearchResultPage(driver);
	Assert.assertTrue(srp.dispalysatausofvalidprod());
}

@When("User enters invalid product {string} into search box field")
public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
	//driver.findElement(By.name("search")).sendKeys(invalidProductText);
	hm.enterproductintoseqrchbox(invalidProductText);
}

@Then("User should get message about no product matching")
public void user_should_get_message_about_no_product_matching() {
	Assert.assertEquals("There is no product that matches the search criteria.",srp.getmessageText());
   //Assert.assertEquals("There is no product that matches the search criteria.",driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
}

@When("User not enter any product into search box field")
public void user_not_enter_any_product_into_search_box_field() {
    //Intensionally kept blank
}
}
