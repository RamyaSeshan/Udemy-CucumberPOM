package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumDriver;

public class basePage {

	public static WebDriver driver;
	private WebElement moveToEle;

	public basePage() {
		driver = SeleniumDriver.getDriver();
	}

	public void mouseOver(String locator) {
		if (locator.endsWith("_XPATH")) {
			moveToEle = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		} else if (locator.endsWith("_LINK")) {
			moveToEle = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		}

		Actions actions = new Actions(driver);
		actions.moveToElement(moveToEle).perform();
	}

	public void Click(String locator) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).click();
		} else if (locator.endsWith("_LINK")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).click();
		}
	}

	public boolean isElementPresent(String locator) {

		try {
			if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
			} else if (locator.endsWith("_LINK")) {
				driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}

	}

	
	public void Type(String locator ,String Value) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).sendKeys(Value);
		} else if (locator.endsWith("_LINK")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).sendKeys(Value);
		}
	}
	
	public String  getText(String locator ) {
		//String text = "";
		
		if (locator.endsWith("_XPATH")) {
			locator = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		} else if (locator.endsWith("_LINK")) {
			locator = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		}		
		return locator;
	}
}
