package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.SeleniumDriver;

public class hooks {

	public WebDriver driver;

	@Before
	public void setUp() {
		SeleniumDriver.setUpDriver();
	}

	@After
	public void tearDown(Scenario scn) // this Scenari is from Cucumber
	{

		if (scn.isFailed()) {
			driver = SeleniumDriver.getDriver();
			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(screenshotAs, "image/png", "SreenPrint");
		}
		// SeleniumDriver.tearDown();
	}

}
