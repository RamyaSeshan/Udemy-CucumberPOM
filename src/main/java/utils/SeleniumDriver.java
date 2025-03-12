package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	// This is like the Singleton design pattern where only 1 object created and
	// used across all required classes
	// will have private var
	// will have private constructor so that no other class can create object of
	// this class
	// selenium object will be accessed by amethod , just one instance across all
	// classes shared

	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	private static WebDriverWait wait;
	public static  Properties config = new Properties();
	public static Properties OR = new Properties();
	private FileInputStream fis;

	private SeleniumDriver() {
		try {
			fis = new FileInputStream("./src/main/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			OR.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (config.getProperty("browser").equalsIgnoreCase("edge"))
			WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (seleniumDriver == null)
			seleniumDriver = new SeleniumDriver();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}

		seleniumDriver = null;
	}

	public static void navigateToBrowser(String URL) {
		driver.get(URL);
	}
}
