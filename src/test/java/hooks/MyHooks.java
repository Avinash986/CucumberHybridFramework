package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	@Before
	public void setup() {
		Properties prop = ConfigReader.initilizeProperties();
		 DriverFactory.initilizeBrowser(prop.getProperty("browser"));
		 driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	@After 
	public void tearDown(Scenario scenario) {
		
		String scenarioName=scenario.getName().replaceAll(" ","_");
		if (scenario.isFailed()) {
			byte[] srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenShot, "image/png", scenarioName);
		}
		driver.quit();
	}

}
